package com.dxctraining.jmsexperiment1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MpReceiver1 {
    @JmsListener(destination = "mp",containerFactory = "listenerFactory")
    public void receiveMPMessage(SimpleMessage simpleMessage){
        System.out.println("***********inside receiver 1 Welcome in Madhya pradesh "+simpleMessage.getReceiverName()
                + "message is"+ simpleMessage.getMessageText()    );

    }
}
