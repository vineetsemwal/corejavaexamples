package com.dxctraining.oninevideo.usermgt.controllers;

import com.dxctraining.oninevideo.usermgt.dto.CreateUserRequest;
import com.dxctraining.oninevideo.usermgt.entities.AppUser;
import com.dxctraining.oninevideo.usermgt.entities.UserDto;
import com.dxctraining.oninevideo.usermgt.service.IUserService;
import com.dxctraining.onlinevideo.shared.DeactivateUserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/add")
    public UserDto add(@RequestBody CreateUserRequest request){
        AppUser user=new AppUser(request.getName(),request.getInterest());
        user=service.save(user);
        UserDto dto=new UserDto(user.getId(),user.getName(),user.getInterest(), user.getVideos());
        return dto;
    }

    @GetMapping("/get/{id}")
    public UserDto getUser(@PathVariable("id")Integer id){
       AppUser user =service.findById(id);
        UserDto dto=new UserDto(user.getId(),user.getName(),user.getInterest(), user.getVideos());
        return dto;
    }

    @DeleteMapping("/remove/{id}")
    public void removeUser(@PathVariable("id")Integer id){
        service.deleteById(id);
        DeactivateUserMessage msg=new DeactivateUserMessage(id);
        jmsTemplate.convertAndSend("user.deactivated",msg);
    }
    

}
