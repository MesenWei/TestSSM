package com.demo.java.aop.springaop.annotation.intricacy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切点函数
 * 切点函数详细说明见readme。
 * Created by maosheng on 2017/6/13.
 */
@Aspect
public class AdviceFunctionWithin {
    @Pointcut("@within(com.demo.java.aop.springaop.annotation.PointCutClass)")
    public void pointCutClass() {
    }

    @Before("within(com.demo.java.aop.springaop.annotation.intricacy.*)")
    public void before(JoinPoint jp){
        System.out.println("----------前置通知----------");
    }

    @After("pointCutClass()")
    public void after(JoinPoint jp){
        System.out.println("----------最终通知----------");
    }

}
