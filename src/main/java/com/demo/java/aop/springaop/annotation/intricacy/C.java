package com.demo.java.aop.springaop.annotation.intricacy;

import com.demo.java.aop.springaop.annotation.PointCutClass;

/**
 * 测试Target
 * Created by maosheng on 2017/6/14.
 */
@PointCutClass
public class C implements B{
    public void cA(){
        System.out.println("method cA is running !");
    }
}
