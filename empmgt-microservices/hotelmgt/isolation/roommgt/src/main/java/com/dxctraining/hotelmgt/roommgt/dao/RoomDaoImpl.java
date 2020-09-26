package com.dxctraining.hotelmgt.roommgt.dao;

import com.dxctraining.hotelmgt.roommgt.entities.Room;
import com.dxctraining.hotelmgt.roommgt.exceptions.RoomNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Random;

@Repository
public class RoomDaoImpl implements IRoomDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Room save(Room room) {
        String id = generateId();
        room.setId(id);
        room = entityManager.merge(room);
        return room;
    }

    @Override
    public Room findById(String id) {
        Room room = entityManager.find(Room.class, id);
        if(room==null){
            throw new RoomNotFoundException("room not found for id="+id);
        }
        return room;
    }

    public String generateId() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randNum = random.nextInt(100);
            builder.append(randNum);
        }
        String id = builder.toString();
        return id;
    }


}
