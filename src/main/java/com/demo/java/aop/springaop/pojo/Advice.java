package com.demo.java.aop.springaop.pojo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * spring aop 的五个通知。
 * 作用是：在运行时，动态地将代码切入到类的指定方法、指定位置上。
 * Created by weimaosheng on 2016/9/27.
 */
public class Advice {
    /**
     * 切面的前置方法 即方法执行前拦截到的方法 记录并输出
     * 在目标方法执行之前的通知
     * @param joinPoint
     */
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("======================方法开始======================");
        Object object = joinPoint.getSignature();
        String methodName = joinPoint.getSignature().getName();
        List<Object> list = Arrays.asList(joinPoint.getArgs());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String rightnow=sdf.format(date);
        System.out.println(rightnow+"执行了【"+object+"方法开始执行......】");
        System.out.println("******参数"+list+"******");
    }

    /**
     * 切面的后置方法，不管抛不抛异常都会走此方法
     * 在目标方法执行之后的通知
     * @param joinPoint
     */
    public void afterMethod(JoinPoint joinPoint){
        Object object = joinPoint.getSignature();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String rightnow=sdf.format(date);
        System.out.println(rightnow+"执行了【"+object+"方法结束......】");
    }

    /**
     * 在方法正常执行通过之后执行的通知叫做返回通知
     * 可以返回到方法的返回值 在注解后加入returning
     * @param joinPoint
     */
    public void afterReturn(JoinPoint joinPoint, Object result){
        Object object = joinPoint.getSignature();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String rightnow=sdf.format(date);
        System.out.println(rightnow+"执行了【"+object+"方法正常执行结束......】"+"【返回结果:"+result+"】");
        System.out.println("√√√√√√√√√√√√√√√√√√√√√√方法结束√√√√√√√√√√√√√√√√√√√√√√");
    }

    /**
     * 在目标方法非正常执行完成 发生异常 抛出异常的时候会走此方法
     * 获得异常可以用throwing
     * @param joinPoint
     * @param ex
     */
    public void afterThrowing(JoinPoint joinPoint, Exception ex ){
        Object object = joinPoint.getSignature();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String rightnow=sdf.format(date);
        System.out.println(rightnow+"执行了【"+object+"方法发生异常......】"+"【异常报告:"+ex+"】");
        System.out.println("xxxxxxxxxxxxxxxxxx方法发生异常结束xxxxxxxxxxxxxxxxxx");
    }

    /**
     * 环绕通知需要携带ProceedingJoinPoint 这个类型的参数
     * 环绕通知类似于动态代理的全过程 ProceedingJoinPoint类型的参数可以决定是否执行目标函数
     * 环绕通知必须有返回值
     * 应用场景：需要统计某个方法执行的时间。
     * 注意：
     *      1.如果设置了环绕通知，当出现异常的时候，异常通知则不会执行。
     * @param proceedingJoinPoint
     * @return
     */
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        Object result=null;
        Object classMethod=proceedingJoinPoint.getSignature();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String rightnow=sdf.format(date);
        try {
            //前置通知
            System.out.println(rightnow+"环绕通知执行了【"+classMethod+"方法开始执行......】");
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println(rightnow+"环绕通知正常执行【"+classMethod+"方法完毕......】"+"【返回结果：】"+result);
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //异常通知
            System.out.println(rightnow+"环绕通知非正常执行【"+classMethod+"方法完毕，抛出异常......】"+"【返回异常：】"+e);
        }
            //后置通知
        System.out.println(rightnow+"环绕通知执行【"+classMethod+"方法完毕】");
        return result;
    }
}