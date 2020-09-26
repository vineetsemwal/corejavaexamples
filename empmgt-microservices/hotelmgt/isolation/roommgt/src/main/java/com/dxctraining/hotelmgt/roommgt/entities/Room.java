package com.dxctraining.hotelmgt.roommgt.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    private String id;

    private int floorNo;

    private int roomNo;

    public Room(){

    }

    public Room(int floorNo, int roomNo){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id.equals(room.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
