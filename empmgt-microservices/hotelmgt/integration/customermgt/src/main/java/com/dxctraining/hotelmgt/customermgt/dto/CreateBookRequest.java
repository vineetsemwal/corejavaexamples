package com.dxctraining.hotelmgt.customermgt.dto;

import javax.validation.constraints.NotBlank;

public class CreateBookRequest {

    private int customerId;

    @NotBlank
    private String roomId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
