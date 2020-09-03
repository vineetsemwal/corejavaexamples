package com.dxctraining.jmsexperiment1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MpReceiver1 {
    @JmsListener(destination = "topic.mp",containerFactory = "listenerFactory")
    public void receiveMPMessage(SimpleMessage message){
        System.out.println("***********inside receiver 1 Welcome in Madhya pradesh "+message.getReceiverName()
                + "message is"+ message.getMessageText()   );

    }
}
