package com.demo.jms.amq;

import com.demo.java.date.DateUtil;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Date;

/**
 * Created by maosheng on 2016/8/17
 */
@Service
public class TestReDelivery implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String text = textMessage.getText();
                System.out.printf("时间：，%s", DateUtil.sdfS(new Date()));
                System.out.printf("QueueReceiver2接收到消息：,%s",text);
                throw new JMSException("process failed");
            } catch (JMSException e) {
                throw JmsUtils.convertJmsAccessException(e);
            }
        }
    }
}
