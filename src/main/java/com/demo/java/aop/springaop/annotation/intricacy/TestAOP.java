package com.demo.java.aop.springaop.annotation.intricacy;

import com.demo.java.aop.springaop.annotation.PointCutClass;
import com.demo.java.aop.springaop.annotation.PointCutMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by maosheng on 2017/6/14.
 */
@PointCutClass
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/testspringaop-annotation.xml"})
public class TestAOP implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void a(){
        System.out.println("method aaaaaa is running!!!!!!!！");
    }

    public String b(){
        System.out.println("method bbbbbb is running!!!!!!!!");

        return "success";
    }

    @PointCutMethod
    public Integer c(Integer conut){
        System.out.println("method cccccc is running!!!!!!!!" + conut);
        return conut;
    }

    public void d(A a){
        System.out.println("method dddddd is running!!!!!!!!");
    }

    @Test
    public void test1(){
        TestAOP aop = (TestAOP) applicationContext.getBean("testaop2");
        aop.a();
        aop.b();
        aop.c(123);
        aop.d(new A());
    }

    @Test
    public void test2(){
        C c = (C) applicationContext.getBean("c");
        c.cA();
    }
}
