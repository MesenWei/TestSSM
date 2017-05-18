package com.demo.java.springaop.paramming;

import com.demo.java.springtransaction.ServiceFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by weimaosheng on 2016/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/springtest.xml"})
public class AopTest implements ApplicationContextAware {
    @Autowired
    DemoCommon dC ;

    ApplicationContext applicationContext;

    @Test
    public void testAop() throws Exception {
        dC.aaa("1234","abcd");

    }

    @Test
    public void testAdvisor(){
        ServiceFacade serviceFacade = (ServiceFacade) applicationContext.getBean("serviceFacade");

        serviceFacade.addUserBook();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
