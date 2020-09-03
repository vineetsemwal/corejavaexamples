package com.dxctraining.onlinevideo.videomgt.controllers;

import com.dxctraining.onlinevideo.shared.InterestMessage;
import com.dxctraining.onlinevideo.videomgt.dto.CreateVideoRequest;
import com.dxctraining.onlinevideo.videomgt.dto.VideoDto;
import com.dxctraining.onlinevideo.videomgt.entities.Video;
import com.dxctraining.onlinevideo.videomgt.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/videos")
@RestController
public class VideoController {

    @Autowired
    private IVideoService videoService;

    @Autowired
    private JmsTemplate template;

    @PostMapping("/add")
    public VideoDto add(@RequestBody  CreateVideoRequest request){
        Video video=new Video(request.getInterest(),request.getDescription());
        video=videoService.save(video);

        InterestMessage msg=new InterestMessage(video.getId(),video.getInterest());
        template.convertAndSend("topic.video",msg);
        VideoDto response=new VideoDto(video.getId(),video.getInterest(), video.getDescription());
        return response;
    }

}
