package com.dxctraining.hotelmgt.roommgt.controllers;

import com.dxctraining.hotelmgt.roommgt.dto.CreateRoomRequest;
import com.dxctraining.hotelmgt.roommgt.dto.RoomDto;
import com.dxctraining.hotelmgt.roommgt.entities.Room;
import com.dxctraining.hotelmgt.roommgt.service.IRoomService;
import com.dxctraining.hotelmgt.roommgt.util.RoomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import javax.validation.*;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomUtil roomUtil;

    @Autowired
    private IRoomService roomService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDto add(@RequestBody @Valid CreateRoomRequest requestData){
        Room room=new Room(requestData.getFloorNo(),requestData.getRoomNo());
        room=roomService.save(room);
        RoomDto response=roomUtil.toDto(room);
        return response;
    }

    @GetMapping("/get/{id}")
    public RoomDto getRoom(@PathVariable("id") @NotBlank String id){
      Room room=  roomService.findById(id);
      RoomDto dto=roomUtil.toDto(room);
      return dto;
    }



}
