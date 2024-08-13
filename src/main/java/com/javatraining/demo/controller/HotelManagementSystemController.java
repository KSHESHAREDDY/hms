package com.javatraining.demo.controller;

import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.domain.Reservation;
import com.javatraining.demo.dto.ReservationRequestDTO;
import com.javatraining.demo.dto.ReservationResponseDTO;
import com.javatraining.demo.exception.InvalidDataException;
import com.javatraining.demo.exception.SqlException;
import com.javatraining.demo.service.HotelManagementSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hms")
public class HotelManagementSystemController {

    @Autowired
    HotelManagementSystemService hotelManagementSystemService;

    @PostMapping(path = "/addGuest", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addGuest(@RequestBody Guest guest) {
        try {
            hotelManagementSystemService.addGuest(guest);
        } catch (InvalidDataException ex) {
            return ResponseEntity.badRequest().body(ex);
        }
        return ResponseEntity.ok("Guest Added Successfully");
    }

    @PostMapping(path = "/reservation")
    public ReservationResponseDTO bookRoom(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        try {
            Reservation reservation = hotelManagementSystemService.makeReservation(reservationRequestDTO);
            ReservationResponseDTO response = new ReservationResponseDTO(200L,
                    "Reservation Created Successfully");
            response.setReservation(reservation);
            return response;
        } catch (SqlException exception) {
            ReservationResponseDTO response = new ReservationResponseDTO(exception.getId(),
                    exception.getStatusMessage());
            return response;
        }
    }

    @PutMapping(path = "/cancel/{reservationId}")
    public void cancelReservation(@PathVariable String reservationId) {
        Long rId = Long.parseLong(reservationId);
        hotelManagementSystemService.cancelReservation(rId);
    }

}
