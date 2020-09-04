package com.dxctraining.onlinevideo.videomgt.controllers;

import com.dxctraining.onlinevideo.shared.InterestMessage;
import com.dxctraining.onlinevideo.videomgt.dto.CreateVideoRequest;
import com.dxctraining.onlinevideo.videomgt.dto.VideoDto;
import com.dxctraining.onlinevideo.videomgt.entities.Video;
import com.dxctraining.onlinevideo.videomgt.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/videos")
@RestController
public class VideoController {

    @Autowired
    private IVideoService videoService;

    @Autowired
    private JmsTemplate template;

    @PostMapping("/add")
    public VideoDto add(@RequestBody  CreateVideoRequest request){
        Video video=new Video(request.getInterest(),request.getDescription(), request.getUploaderUserId());
        video=videoService.save(video);

        InterestMessage msg=new InterestMessage(video.getId(),video.getInterest(),"add");
        template.convertAndSend("topic.video",msg);
        VideoDto response=new VideoDto(video.getId(),video.getUploaderUserId() ,video.getInterest(), video.getDescription());
        return response;
    }

    @GetMapping("/get/{id}")
    public VideoDto getVideo(@PathVariable("id")Integer id){
       Video video= videoService.findById(id);
       VideoDto response=new VideoDto(video.getId(),video.getUploaderUserId(), video.getInterest(), video.getDescription());
       return response;
    }

    @DeleteMapping("/remove/{id}")
    public VideoDto remove(@PathVariable("id") Integer id){
        Video video=videoService.findById(id);
        videoService.deleteById(id);
        InterestMessage msg=new InterestMessage(id,video.getInterest(),"remove");
        template.convertAndSend("topic.video",msg);
        VideoDto response=new VideoDto(video.getId(),video.getUploaderUserId() ,video.getInterest(), video.getDescription());
        return response;
    }



}
