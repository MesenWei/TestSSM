package com.demo.java.aop.springaop.pojo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 纯POJO切面
 * Created by maosheng on 2017/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/testspringaop-xml.xml"})
public class TestAOP implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void a(){
        System.out.println("method aaaaaa is running!");
    }

    public String b(){
        System.out.println("method bbbbbb is running!");

        return "success";
    }

    @Test
    public void test1(){
        TestAOP aop = (TestAOP) applicationContext.getBean("testaop");
        aop.a();
        aop.b();
    }

    /**
     * test1与test2相比，test2没有被aop管理，
     * 说明：被代理的对象必须由spring管理，
     * 并且通过spring获取后再执行方法，才能生效。
     */
    @Test
    public void test2(){
        TestAOP aop = new TestAOP();
        aop.a();
        aop.b();
    }

}
