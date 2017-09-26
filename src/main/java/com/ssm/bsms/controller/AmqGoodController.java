package com.ssm.bsms.controller;

import com.demo.jms.amq.QueueSender1;
import com.demo.jms.amq.TopicSender1;
import com.demo.jms.pressure.QueueSender3;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

/**
 * activemq测试:spring-amq-good.xml
 * Created by maosheng on 2017/5/25.
 */
@Controller
@RequestMapping("ampgood")
public class AmqGoodController {

    @Autowired
    private QueueSender1 queueSender;
    @Autowired
    private QueueSender3 queueSender3;
    @Autowired
    private TopicSender1 topicSender;
    @Autowired(required = false)
    @Qualifier("a")
    private Destination aDestination;
    @Autowired(required = false)
    @Qualifier("b")
    private Destination bDestination;
    @Autowired(required = false)
    @Qualifier("c")
    private Destination destination3;

    /**
     * 发送消息到队列
     * Queue队列：仅有一个订阅者会收到消息，消息一旦被处理就不会存在队列中
     * @param message
     * @return String
     */
    @ResponseBody
    @RequestMapping("queueSender")
    public String queueSender(@RequestParam("message")String message){
        String opt;
        try {
            ActiveMQQueue a = (ActiveMQQueue) aDestination;
            queueSender.send(a.getPhysicalName(), message);
            opt = "suc";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }

    @ResponseBody
    @RequestMapping("topicSender")
    public String topoicSender(@RequestParam("message")String message){
        String opt = "";

        try {
            ActiveMQTopic b = (ActiveMQTopic) bDestination;
            topicSender.send(b.getPhysicalName(), message);
            opt = "suc";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }
    @ResponseBody
    @RequestMapping("queueSenderPressure")
    public String queueSenderPressure(@RequestParam("message")String message){
        String opt ;

        try {
            ActiveMQQueue d3 = (ActiveMQQueue) destination3;
            queueSender3.send(d3.getPhysicalName(), message);
            opt = "sucs";
        } catch (Exception e) {
            opt = e.getCause().toString();
        }
        return opt;
    }
}
