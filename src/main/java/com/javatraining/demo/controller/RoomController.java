package com.javatraining.demo.controller;

import com.javatraining.demo.domain.Room;
import com.javatraining.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class RoomController {

    @Autowired
    RoomService roomService;

    //create
    @PostMapping(path = "/addRoom")
    Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    //update
    @PutMapping(path = "/updateRoom")
    Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

    //get
    @GetMapping(path = "/getRoom")
    Room getRoomById(@RequestBody Room room) {
        return roomService.getRoomById(room.getId());
    }

    //delete
    @DeleteMapping(path = "/roomDelete")
    String deleteRoomById(@RequestBody Room room) {
        roomService.deleteRoomById(room.getId());
        return "Room Deleted";
    }
}
