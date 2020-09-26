package com.dxctraining.hotelmgt.roommgt.service;

import com.dxctraining.hotelmgt.roommgt.dao.IRoomDao;
import com.dxctraining.hotelmgt.roommgt.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private IRoomDao roomDao;

    @Override
    public Room save(Room room) {
        room = roomDao.save(room);
        return room;
    }

    @Override
    public Room findById(String id) {
        Room room = roomDao.findById(id);
        return room;
    }
}
