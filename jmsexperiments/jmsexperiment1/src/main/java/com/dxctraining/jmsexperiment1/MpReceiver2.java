package com.dxctraining.jmsexperiment1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MpReceiver2 {
    @JmsListener(destination = "mp",containerFactory = "listenerFactory")
    public void receiveMPMessage(SimpleMessage simpleMessage){
        System.out.println("*********** inside receiver 2 Welcome in Madhya pradesh "+simpleMessage.getReceiverName()
                + "message is"+ simpleMessage.getMessageText()    );

    }
}
