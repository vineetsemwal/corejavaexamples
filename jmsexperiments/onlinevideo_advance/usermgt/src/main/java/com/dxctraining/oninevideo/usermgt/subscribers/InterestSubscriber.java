package com.dxctraining.oninevideo.usermgt.subscribers;

import com.dxctraining.oninevideo.usermgt.entities.AppUser;
import com.dxctraining.oninevideo.usermgt.service.IUserService;
import com.dxctraining.onlinevideo.shared.InterestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InterestSubscriber {

    @Autowired
    private IUserService service;

    @JmsListener(destination = "topic.video", containerFactory = "listenerFactory")
    public void receiveMessage(InterestMessage received) {
        String interest=received.getInterest();
        int videoId=received.getVideoId();
      System.out.println("interest message received="+interest+" video id="+videoId);
      if(received.getOperation().equals("add"))
      {
          service.addVideo(interest,videoId);
      }else {
          service.removeVideo(interest,videoId);
      }

    }
}
