package com.dxctraining.receiverapp;

import com.dxctraining.shared.DxcMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AndhraReceiver1 {

    @JmsListener(destination = "andhra", containerFactory = "listenerFactory")
    public void receiveTelaganaMessage(DxcMessage received) {
        System.out.println("***********inside Andhra pradesh receiver 1 Welcome in andhra="+received.getReceiver()
               + "message is"+ received.getMessage()    );
    }
}
