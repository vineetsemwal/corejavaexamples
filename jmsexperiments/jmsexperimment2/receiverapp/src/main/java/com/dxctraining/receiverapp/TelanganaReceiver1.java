package com.dxctraining.receiverapp;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TelanganaReceiver1 {

    @JmsListener(destination = "telangana", containerFactory = "listenerFactory")
    public void receiveTelaganaMessage(String simpleMessage) {
        // System.out.println("***********inside telanagna receiver 1 Welcome in telangana="+simpleMessage.getReceiverName()
        //         + "message is"+ simpleMessage.getMessageText()    );
        System.out.println("received msg=" + simpleMessage);
    }
}
