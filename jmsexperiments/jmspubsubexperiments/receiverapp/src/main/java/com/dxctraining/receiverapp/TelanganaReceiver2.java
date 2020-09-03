package com.dxctraining.receiverapp;


import com.dxctraining.shared.DxcMessage;
import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class TelanganaReceiver2 {

    @JmsListener(destination = "india.telangana", containerFactory = "listenerFactory")
    public void receiveTelaganaMessage(DxcMessage received) {
        System.out.println("***********inside telanagna receiver 2 Welcome in telangana="+received.getReceiver()
                + "message is"+ received.getMessage()    );
    }
}
