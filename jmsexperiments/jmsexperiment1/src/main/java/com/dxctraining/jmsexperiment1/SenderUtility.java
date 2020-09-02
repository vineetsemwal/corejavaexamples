package com.dxctraining.jmsexperiment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SenderUtility {

    @Autowired
    private JmsTemplate template;

    @PostConstruct
    public void send(){
        SimpleMessage ankitMsg = new SimpleMessage("ankit","madhya pradesh", "hello ankit");
        SimpleMessage anujMsg = new SimpleMessage("anuj","madhya pradesh" ,"hello anuj");
        SimpleMessage vineelMsg = new SimpleMessage("vineel","telangana" ,"hello vineel");
        SimpleMessage roopsaiMsg=new SimpleMessage("roopsai","andhra pradesh","hello roopsai");

        template.convertAndSend("mp", ankitMsg);
        System.out.println("************sent message to ankit");
        template.convertAndSend("mp", anujMsg);
        System.out.println("************sent message to anuj");
        template.convertAndSend("telangana", vineelMsg);
        System.out.println("************sent message to vineel");
        template.convertAndSend("andhra",roopsaiMsg);
        System.out.println("************sent message to ropsai");


    }
}
