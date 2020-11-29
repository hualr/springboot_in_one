package com.example.spring_in_one.base.utils;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/25 23:22
 * Version: 1.0.0
 */
public class MyException extends Throwable {
    private String message;
    private Exception exception;
    private Throwable throwable;
    public MyException(){

    }

    public MyException(String message){
        this.message=message;
    }
    public MyException(Exception exception){
        this.exception=exception;
    }
    public MyException(String message,Throwable throwable){
        this.message=message;
        this.throwable=throwable;
    }
    public MyException(Throwable throwable){
        this.throwable=throwable;
    }
}
