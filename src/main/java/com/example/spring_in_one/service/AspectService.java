package com.example.spring_in_one.service;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/23 11:50
 * Version: 1.0.0
 */
@Aspect
@Component
public class AspectService {
    /**
     * 第一个* 表示的是返回值的类型是任意的 这里可以进行限制
     * 第二个参数代表的是AOP服务所切的包名
     * 第三个 ..表示的是当前包和子包
     * 第二个 * 表示的是类名 此处可以自定义
     * 第三个 * 表示的是方法名
     * (..) 表示接收任何方法
     */
    @Before(value="execution(* com.example.spring_in_one.controller..*.*(..))")
    public void before(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("方法执行之前:"+"["+name+"]"+ Arrays.toString(args));
    }

    @AfterReturning(value="execution(* com.example.spring_in_one.controller.*.*(..))" ,returning = "result")
    public void afterRunning(JoinPoint joinPoint,Object result){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        //根据返回结果处理不同的逻辑
        if ("OK".equals(result)){
            System.out.println("返回了OK");
        }
        System.out.println("方法返回后执行:"+"["+name+"]"+ ",["+Arrays.toString(args)+"]"+",["+result+"]");
    }

    @After(value="execution(* com.example.spring_in_one.controller.*.*(..))")
    public void after(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("方法执行之后"+"["+name+"]"+  Arrays.toString(args));
    }

    /**
     * 即使抛出异常 也会执行方法后方法 但是不会执行返回方法
     */
    @AfterThrowing(value = "execution (* com.example.spring_in_one.controller.*.*(..)))", throwing = "e")
    public void throwException(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常方法调用:" + methodName + " 异常信息" + e);
    }

    /**
     * 环绕方法先于before
     * 后于after
     */
    @Around(value="execution(* com.example.spring_in_one.controller.*.*(..))")
    public Object rounding(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("环绕方法开始");
        Object proceed = null;
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("方法调用过程预备");
            proceed = joinPoint.proceed(args);
            System.out.println("执行方法返回值:"+proceed);
            System.out.println("方法调用过程完成");
        } catch (Throwable throwable) {
            throw new Throwable("方法调用失败");
        }
        long end = System.currentTimeMillis();
        System.out.println("方法执行时间"+(start-end));
        System.out.println("环绕方法结束");
        return proceed;
    }

}