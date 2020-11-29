package com.example.spring_in_one.base.utils;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/25 23:14
 * Version: 1.0.0
 */
public class MyExceptionUtils {

    public MyExceptionUtils() {
    }

    public static MyException mxe(String msg, Throwable t, Object... params){
        return new MyException(StringUtils.format(msg, params),t);
    }

    public static MyException mxe(String msg, Object... params){
        return new MyException(StringUtils.format(msg, params));
    }

    public static MyException mxe(Throwable t){
        return new MyException(t);
    }

}