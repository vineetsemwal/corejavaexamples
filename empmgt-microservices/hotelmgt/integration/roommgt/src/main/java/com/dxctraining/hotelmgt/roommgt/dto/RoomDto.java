package com.dxctraining.hotelmgt.roommgt.dto;

public class RoomDto {
    private String id;

    private int floorNo;

    private int roomNo;

    public RoomDto(){

    }

    public RoomDto(String id, int floorNo, int roomNo){
        this.id=id;
        this.floorNo=floorNo;
        this.roomNo=roomNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

