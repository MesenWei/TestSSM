package com.demo.java.springaop.paramming;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by weimaosheng on 2016/9/27.
 */
public class DemoAop2 {
    public void authority(JoinPoint jp) {
        System.out.println("被代理方法名字："+jp.getSignature().getName());
        System.out.println("被代理方法参数："+jp.getArgs());
        System.out.println("被代理对象："+jp.getTarget());
        System.out.println("现在调用的是权限验证");

    }


    public  void log(JoinPoint jp, Object rvt){
        System.out.println("被代理方法名字："+jp.getSignature().getName());
        System.out.println("被代理方法参数："+jp.getArgs());
        System.out.println("被代理对象："+jp.getTarget());
        System.out.println("被代理对象的返回值"+rvt);
        System.out.println("现在调用的是日志管理");
    }


    public Object processTx(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("现在调用的是事务开启");
        //得到业务方法的参数
        Object[] args=pjp.getArgs();
        System.out.println("业务方法的参数："+args);
        //被代理对象的业务方法
        Object result=pjp.proceed(args);
        System.out.println("现在调用的是事务提交或回滚");
        return result;
    }


    public void release(){
        System.out.println("资源已经被释放！");
    }
}