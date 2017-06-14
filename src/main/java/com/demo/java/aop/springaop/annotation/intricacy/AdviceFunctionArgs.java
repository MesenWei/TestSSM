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
public class AdviceFunctionArgs {
    /*@Pointcut(value="execution(* com.demo.java.aop.springaop.annotation.intricacy.*.*(..))")
    private void pointcut1(){}

    @Pointcut("@args(com.demo.java.aop.springaop.annotation.PointCutClass)")
    private void pointcut2(){}

    @Pointcut(value="pointcut1() && pointcut2()")
    private void pointcut3(){}

    @After("pointcut3()")
    public void after(JoinPoint jp){
        System.out.println("----------最终通知----------");
    }*/

    /*@Before(value = "execution(* com.demo.java.aop.springaop.annotation.intricacy.*.*(..)) && args(java.lang.Integer)")
    public void before(JoinPoint jp){
        System.out.println("----------前置通知----------");
    }

    @Before(value = "execution(* com.demo.java.aop.springaop.annotation.intricacy.*.*(..)) && args(params)",argNames = "jp,params")
    public void before2(JoinPoint jp,Integer params){
        System.out.println("----------前置通知2----------" + params);
    }*/

}
