package com.dxctraining.hotelmgt.roommgt.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class CreateRoomRequest {

    @Min(0)
    private int floorNo;

    @Min(0)
    private int roomNo;

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
}
