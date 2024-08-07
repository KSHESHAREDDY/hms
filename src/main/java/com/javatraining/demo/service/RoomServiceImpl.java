package com.javatraining.demo.service;

import com.javatraining.demo.domain.Room;
import com.javatraining.demo.respository.RoomRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepositroy roomRepositroy;

    @Override
    public Room addRoom(Room room) {
        return roomRepositroy.save(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepositroy.save(room);
    }

    @Override
    public Room getRoomById(Long id) {
        Room resultSet = roomRepositroy.findById(id).orElse(null);
        return resultSet;
    }

    @Override
    public void deleteRoomById(Long id) {
        roomRepositroy.deleteById(id);
    }


}
