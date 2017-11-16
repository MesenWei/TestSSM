package com.demo.jms.pressure;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 监听器，JMS？采用的单例模式来获取QueueReceiver3对象，所以，
 * 这个全局变量会一直增加。
 *
 * Created by maosheng on 2017/5/25.
 */
@Component("queueReceiver3")
public class QueueReceiver3 implements MessageListener {
    private int count = 0;
    @Override
    public void onMessage(Message message) {
        try {
            count ++ ;
            System.out.println("接收到第" + count + "消息");
            HandleMsg.test((TextMessage) message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
