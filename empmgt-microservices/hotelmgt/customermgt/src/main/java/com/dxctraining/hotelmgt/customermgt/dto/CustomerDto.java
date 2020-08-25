package com.dxctraining.hotelmgt.customermgt.dto;

public class CustomerDto {

    private Integer id;

    private String name;

    private int floorNo;

    private String roomId;

    private int roomNo;

    public CustomerDto(){

    }

    public CustomerDto(Integer id,String name){
        this.name=name;
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
}
