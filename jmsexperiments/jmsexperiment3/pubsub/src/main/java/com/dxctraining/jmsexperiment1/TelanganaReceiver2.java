package com.dxctraining.jmsexperiment1;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TelanganaReceiver2 {

    @JmsListener(destination = "topic.telangana",containerFactory = "listenerFactory")
    public void receiveTelaganaMessage(SimpleMessage simpleMessage){
        System.out.println("***********inside telanagana receiver2  Welcome in telangana="+simpleMessage.getReceiverName()
                + "message is"+ simpleMessage.getMessageText()    );

    }
}
