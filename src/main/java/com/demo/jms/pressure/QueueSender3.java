package com.demo.jms.pressure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by maosheng on 2017/5/25.
 */
@Service
public class QueueSender3 {
    @Autowired(required = false)
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 发送一条消息到指定的队列（目标）
     * @param queueName 队列名称
     * @param message 消息内容
     */
    public void send(String queueName, final String message){
        /*
         * 当destination为字符串时，spring默认指定destination类型为Queue。
         * spring默认指定destination是在JmsTemplate中的pubSubDomain属性指定的：
         * pubSubDomain = false 字符串destination类型为Queue
         * pubSubDomain = true  字符串destination类型为Topic
         */
        for(int i=0,l=20;i<l;i++){
            jmsTemplate.send(queueName,session -> session.createTextMessage(message));
        }
    }
}
