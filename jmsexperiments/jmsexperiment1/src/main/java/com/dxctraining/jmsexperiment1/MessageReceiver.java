package com.dxctraining.jmsexperiment1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @JmsListener(destination = "mp",containerFactory = "listenerFactory")
    public void receiveMPMessage(SimpleMessage simpleMessage){
    System.out.println("***********Welcome in Madhya pradesh "+simpleMessage.getReceiverName()
    + "message is"+ simpleMessage.getMessageText()    );

    }

    @JmsListener(destination = "telangana",containerFactory = "listenerFactory")
    public void receiveTelaganaMessage(SimpleMessage simpleMessage){
        System.out.println("***********Welcome in telangana="+simpleMessage.getReceiverName()
                + "message is"+ simpleMessage.getMessageText()    );

    }

    @JmsListener(destination = "andhra",containerFactory = "listenerFactory")
    public void receiveAndhraMessage(SimpleMessage simpleMessage){
        System.out.println("***********Welcome in andhara pradesh="+simpleMessage.getReceiverName()
                + "message is"+ simpleMessage.getMessageText()    );

    }
}
