package com.dxctraining.hotelmgt.roommgt.service;

import com.dxctraining.hotelmgt.roommgt.entities.Room;

public interface IRoomService {

    Room save(Room room);

    Room findById(String id);


}
