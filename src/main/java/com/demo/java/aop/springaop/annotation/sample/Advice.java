package com.demo.java.aop.springaop.annotation.sample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 使用注解配置AOP
 * Created by maosheng on 2017/6/13.
 */
@Aspect
public class Advice {
    /*
    方式1：切点使用注解。被添加注解的方法就是aop的切入点。
     */
    @Pointcut("@annotation(com.demo.java.aop.springaop.annotation.PointCutMethod)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint jp){
        System.out.println("----------前置通知----------");
    }

    /*
    方式2：通知使用注解。
     */
    @Before("@annotation(com.demo.java.aop.springaop.annotation.PointCutMethod)")
    public void before2(JoinPoint jp){
        System.out.println("----------前置通知----------");
    }


    /*
    方式3:切点使用execution
     */
    @Pointcut("execution(* com.demo.java.aop.springaop.annotation.*.*(..))")
    public void pointCut2() {
    }

    @After("pointCut2()")
    public void after(JoinPoint jp){
        System.out.println("----------最终通知----------");
    }

    /*
    方式4:通知使用execution
     */
    @AfterReturning(value = "execution(* com.demo.java.aop.springaop.annotation.*.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("返回的结果是"+result);
    }
}
