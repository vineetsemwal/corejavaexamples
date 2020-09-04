package com.dxctraining.onlinevideo.videomgt.subscribers;

import com.dxctraining.onlinevideo.shared.DeactivateUserMessage;
import com.dxctraining.onlinevideo.videomgt.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DeactivatedUserMsgSubscriber {

    @Autowired
    private IVideoService service;

    @JmsListener(destination = "user.deactivated", containerFactory = "listenerFactory")
    public void receive(DeactivateUserMessage msg){
       Integer userId= msg.getUserId();
       service.removeVideosUploadedByUser(userId);
    }

}
