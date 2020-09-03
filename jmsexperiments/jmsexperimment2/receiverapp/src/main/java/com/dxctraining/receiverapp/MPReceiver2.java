package com.dxctraining.receiverapp;

import com.dxctraining.shared.DxcMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MPReceiver2 {

    @JmsListener(destination = "mp", containerFactory = "listenerFactory")
    public void receiveTelaganaMessage(DxcMessage received) {
        System.out.println("***********inside madhya pradesh receiver 2 Welcome in mp="+received.getReceiver()
               + "message is"+ received.getMessage()    );
    }
}
