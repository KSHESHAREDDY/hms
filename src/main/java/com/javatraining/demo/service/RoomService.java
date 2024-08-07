package com.javatraining.demo.service;

import com.javatraining.demo.domain.Room;

public interface RoomService {
    Room addRoom(Room room);
    Room updateRoom(Room room);

    Room getRoomById(Long id);

    void deleteRoomById(Long id);
}
