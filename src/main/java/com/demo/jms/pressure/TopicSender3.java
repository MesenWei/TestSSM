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
public class TopicSender3 {
    @Autowired(required = false)
    @Qualifier("jmsTopicTemplate")
    private JmsTemplate jmsTemplate;

    /**
     * 发送一条消息到指定的队列（目标）
     * @param topicName 队列名称
     * @param message 消息内容
     */
    public void send(String topicName,final String message){
        jmsTemplate.send(topicName,session -> session.createTextMessage(message));
    }
}
