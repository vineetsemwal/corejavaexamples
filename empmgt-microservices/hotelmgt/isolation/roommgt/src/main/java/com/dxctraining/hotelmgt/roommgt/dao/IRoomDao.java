package com.dxctraining.hotelmgt.roommgt.dao;

import com.dxctraining.hotelmgt.roommgt.entities.Room;

public interface IRoomDao {

    Room save(Room room);

    Room findById(String id);



}
