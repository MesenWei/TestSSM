package com.demo.jms.amq;

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
public class QueueSender1 {
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
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
