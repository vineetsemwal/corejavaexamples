package com.dxctraining.hotelmgt.customermgt.util;

import com.dxctraining.hotelmgt.customermgt.dto.CustomerDto;
import com.dxctraining.hotelmgt.customermgt.dto.RoomDto;
import com.dxctraining.hotelmgt.customermgt.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {

    public CustomerDto toDto(Customer customer, RoomDto room) {
        CustomerDto dto = new CustomerDto(customer.getId(), customer.getName());
        if (room != null) {
            dto.setFloorNo(room.getFloorNo());
            dto.setRoomNo(room.getRoomNo());
            dto.setRoomId(room.getId());
        }
        return dto;
    }

}
