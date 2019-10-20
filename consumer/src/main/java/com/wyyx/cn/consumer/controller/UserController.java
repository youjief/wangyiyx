package com.wyyx.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.wyyx.cn.consumer.contants.ReturnResultContants;
import com.wyyx.cn.consumer.contants.UserContants;
import com.wyyx.cn.consumer.contants.wxLogin.WxLogin;
import com.wyyx.cn.consumer.untils.redis.RedisUtils;
import com.wyyx.cn.consumer.untils.result.ReturnResult;
import com.wyyx.cn.consumer.untils.result.ReturnResultUtils;
import com.wyyx.cn.consumer.untils.url.UrlUtils;
import com.wyyx.cn.consumer.vo.PerfectVo;
import com.wyyx.cn.consumer.vo.UserVo;
import com.wyyx.cn.consumer.wxUser.WxUserLogin;
import com.wyyx.cn.provider.model.User;
import com.wyyx.cn.provider.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by GY on 2019/10/17 14:23
 */
@Api(tags = "注册登录")
@Controller
@RequestMapping(value = "/wx")
public class UserController {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private WxLogin wxLogin;

    @Reference
    private UserService userService;



    @ApiOperation("微信登录")
    @GetMapping("/send")
    public String sendCode() { return wxLogin.reqCodeUrl(); }


    @ResponseBody
    @GetMapping("/return")
    public String returnCode(String code) {
        String wxLoginUrl = wxLogin.reqAccessTokenUrl(code);
        String wxReback = UrlUtils.loadURL(wxLoginUrl);
        JSONObject js = JSONObject.parseObject(wxReback);
        String accessToken = js.getString("access_token");
        String openid = js.getString("openid");
        String userInfoUrl = wxLogin.reqUserInfoUrl(accessToken, openid);
        String userInfoStr = UrlUtils.loadURL(userInfoUrl);
        WxUserLogin wxUserLogin = JSONObject.parseObject(userInfoStr, WxUserLogin.class);
        User user = new User();
        user.setOpenid(wxUserLogin.getOpenid());
        user.setNickname(wxUserLogin.getNickname());
        user.setSex(wxUserLogin.getSex());
        user.setLanguage(wxUserLogin.getLanguage());
        user.setCity(wxUserLogin.getCity());
        user.setProvince(wxUserLogin.getProvince());
        user.setCountry(wxUserLogin.getCountry());
        user.setHeadimgurl(wxUserLogin.getHeadimgurl());
        boolean isEixt = userService.isExit(user);
        if (isEixt == false) {
            userService.register(user);
        }
        String wxId = JSONObject.parseObject(userInfoStr).getString("openid");
        redisUtils.set(UserContants.LOGIN_NAME_SPACE +wxId, userInfoStr,180);
        return "redirect:http://localhost:8080/doc.html";
    }
    @ApiOperation("注册")
    @GetMapping(value = "/register")
    @ResponseBody
    public ReturnResult Register(@Valid UserVo userVo) {

       if (userVo.getAgree()!=null) {
           boolean isExit = null == redisUtils.get(UserContants.LOGIN_NAME_SPACE + userVo.getUserName()) ? false : true;
           if (!isExit) {
               User user = new User();
               user.setUserName(userVo.getUserName());
               user.setUserPassword(userVo.getUserPassword());
               user.setUserPhone(userVo.getUserPhone());
               user.setBirthday(userVo.getBirthday());
               user.setSex(userVo.getSex());
               Date date = new Date();
               user.setCreateTime(date);
               user.setIsDelete(0);
               user.setUserLevel(1);
               user.setUpdateTime(date);
               try {
                   redisUtils.set(UserContants.LOGIN_NAME_SPACE + userVo.getUserName(), user, 180);
                   userService.register(user);
               } catch (Exception e) {
                   e.printStackTrace();
               }
               return ReturnResultUtils.returnSuccess(ReturnResultContants.MSG_SUCCESS_EXIST);
           }
           return ReturnResultUtils.returnFail(ReturnResultContants.LOGIN_WRONG, ReturnResultContants.MSG_REGISTER_ALREADY_EXIST);
       }
       return ReturnResultUtils.returnFail(ReturnResultContants.LOGIN_WRONG,ReturnResultContants.MSG_LOGIN_AGREE);
    }
    @ApiOperation("完善用户信息")
    @GetMapping(value = "/userPhone")
    @ResponseBody
    public ReturnResult userPhone(@Valid PerfectVo perfectVo){
        User user = new User();
        user.setUserPhone(perfectVo.getUserPhone());
        user.setUserName(perfectVo.getUserName());
        user.setUserPassword(perfectVo.getUserPassword());
        user.setBirthday(perfectVo.getBirthday());
        user.setSex(perfectVo.getSex());
        userService.userPhone(user);
        return ReturnResultUtils.returnSuccess(ReturnResultContants.MSG_SUCCESS_EXIST);
        }
    @ApiOperation("普通登录")
    @GetMapping(value = "/Login")
    @ResponseBody
    public ReturnResult Login(@ApiParam(value = "手机号", required = true) @RequestParam(value = "userName") String userName,
                              @ApiParam(value = "密码", required = true) @RequestParam(value = "password") String userPassword,
                              @ApiParam(value = "同意服务条款", required = true) @RequestParam(value = "agree")String agree,
                              HttpServletRequest request) {
        if (agree != null) {
            String token = request.getSession().getId();
            User user = userService.login(userName, userPassword);
            if (null != user) {
                String str = JSONObject.toJSONString(user);
                redisUtils.set(token, str, 180);
                request.getSession().setAttribute("token", token);
                return ReturnResultUtils.returnSuccess();
            }
            return ReturnResultUtils.returnFail(ReturnResultContants.LOGIN_WRONG, ReturnResultContants.MSG_WRONG_LOGIN);
        }
        return ReturnResultUtils.returnFail(ReturnResultContants.LOGIN_WRONG,ReturnResultContants.MSG_LOGIN_AGREE);
    }
    }
