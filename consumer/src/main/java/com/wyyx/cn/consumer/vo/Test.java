package com.wyyx.cn.consumer.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jt on 2019/10/21 0:32
 */
public class Test {
    static String regEx = "[\u4e00-\u9fa5]";
    static Pattern pat = Pattern.compile(regEx);

    public static void main(String[] args) {
        String input = "时间";
        System.out.println(isContainsChinese(input));
        input = "hello world";
        System.out.println(isContainsChinese(input));
    }

    public static boolean isContainsChinese(String str)
    {
        Matcher matcher = pat.matcher(str);
        boolean flag = false;
        if (matcher.find())    {
            flag = true;
        }
        return flag;
    }
}
