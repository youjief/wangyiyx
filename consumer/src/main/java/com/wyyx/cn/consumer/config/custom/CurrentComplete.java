package com.wyyx.cn.consumer.config.custom;

import com.wyyx.cn.consumer.vo.SumUserVo;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class CurrentComplete implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(SumUserVo.class)
                && parameter.hasParameterAnnotation(CurrentUser.class);

    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest webRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        SumUserVo sumUserVo = (SumUserVo) webRequest.getAttribute("userToken", RequestAttributes.SCOPE_REQUEST);
        if (sumUserVo != null) {
            return sumUserVo;
        }

        return null;
    }
}
