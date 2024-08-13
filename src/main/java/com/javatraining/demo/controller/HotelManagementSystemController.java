package com.javatraining.demo.controller;

import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.domain.Reservation;
import com.javatraining.demo.dto.ReservationRequestDTO;
import com.javatraining.demo.service.HotelManagementSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hms")
public class HotelManagementSystemController {

    @Autowired
    HotelManagementSystemService hotelManagementSystemService;

    @PostMapping(path = "/addGuest")
    public ResponseEntity addGuest(@RequestBody Guest guest) {
        hotelManagementSystemService.addGuest(guest);
        return ResponseEntity.ok("Guest Added Successfully");
    }

    @PostMapping(path ="/reservation")
    public Reservation bookRoom(@RequestBody ReservationRequestDTO reservationRequestDTO){
        return hotelManagementSystemService.makeReservation(reservationRequestDTO);
    }

    @PutMapping(path = "/cancel/{reservationId}")
    public void cancelReservation(@PathVariable String reservationId) {
        Long rId = Long.parseLong(reservationId);
        hotelManagementSystemService.cancelReservation(rId);
    }

}
