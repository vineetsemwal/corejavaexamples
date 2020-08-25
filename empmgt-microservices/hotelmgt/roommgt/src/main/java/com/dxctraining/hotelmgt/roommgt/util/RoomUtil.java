package com.dxctraining.hotelmgt.roommgt.util;

import com.dxctraining.hotelmgt.roommgt.dto.RoomDto;
import com.dxctraining.hotelmgt.roommgt.entities.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomUtil {

    public RoomDto toDto(Room room){
        RoomDto dto=new RoomDto(room.getId(),room.getFloorNo(),room.getRoomNo());
        return dto;
    }

}
