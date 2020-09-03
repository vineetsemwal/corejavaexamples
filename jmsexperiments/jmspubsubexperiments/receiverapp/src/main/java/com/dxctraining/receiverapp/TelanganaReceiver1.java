package com.dxctraining.receiverapp;

import com.dxctraining.shared.DxcMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TelanganaReceiver1 {

    @JmsListener(destination = "india.telangana", containerFactory = "listenerFactory")
    public void receiveTelaganaMessage(DxcMessage received) {
        System.out.println("***********inside telanagna receiver 1 Welcome in telangana="+received.getReceiver()
               + "message is"+ received.getMessage()    );
    }
}
