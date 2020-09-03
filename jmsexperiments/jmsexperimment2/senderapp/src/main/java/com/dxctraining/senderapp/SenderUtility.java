package com.dxctraining.senderapp;

import com.dxctraining.shared.DxcMessage;
import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class SenderUtility {

    @Autowired
    private JmsTemplate template;

    @PostConstruct
    public void send() throws Exception {
        DxcMessage ankitMsg = new DxcMessage("ankit", "madhya pradesh", "hello ankit");
        DxcMessage anujMsg = new DxcMessage("anuj", "madhya pradesh", "hello anuj");
        DxcMessage vineelMsg = new DxcMessage("vineel", "telangana", "hello vineel");

         template.convertAndSend("mp", ankitMsg);
         System.out.println("************sent message to ankit");
        template.convertAndSend("mp", anujMsg);
         System.out.println("************sent message to anuj");
        template.convertAndSend("telangana", vineelMsg);
        System.out.println("************sent message to vineel");
    }


}
