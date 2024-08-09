package com.javatraining.demo.controller;

import com.javatraining.demo.domain.Guest;
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

    @PostMapping(path = "/addGuests")
    public ResponseEntity addGuests(@RequestBody List<Guest> guests) {
        hotelManagementSystemService.addGuests(guests);
        return ResponseEntity.ok("Guests Added Successfully");
    }

    @GetMapping(path = "/getGuest/{emailId}")
    public Guest getGustes(@PathVariable String emailId){
        return hotelManagementSystemService.getGuestByEmailId(emailId);
    }

    @GetMapping(path = "/getGuest/{emailId}/{phoneNumber}")
    public Guest getGustes(@PathVariable String emailId, @PathVariable Long phoneNumber){
        return hotelManagementSystemService.getGuestByEmailIdAndPhoneNumber(emailId, phoneNumber);
    }

}
