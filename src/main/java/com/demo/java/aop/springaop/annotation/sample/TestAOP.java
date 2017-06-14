package com.demo.java.aop.springaop.annotation.sample;

import com.demo.java.aop.springaop.annotation.PointCutMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 经典的基于代理的AOP
 * Created by maosheng on 2017/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/testspringaop-annotation.xml"})
public class TestAOP implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PointCutMethod
    public void a(){
        System.out.println("method aaaaaa is running!!!!!!!！");
    }

    public String b(){
        System.out.println("method bbbbbb is running!!!!!!!!");

        return "success";
    }

    @Test
    public void test1(){
        TestAOP aop = (TestAOP) applicationContext.getBean("testaop");
        aop.a();
        aop.b();
    }

}
