package com.javatraining.demo.controller;

import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.domain.Reservation;
import com.javatraining.demo.dto.GuestResponseDTO;
import com.javatraining.demo.dto.ReservationRequestDTO;
import com.javatraining.demo.dto.ReservationResponseDTO;
import com.javatraining.demo.exception.InvalidDataException;
import com.javatraining.demo.exception.ReservationException;
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
    public GuestResponseDTO addGuest(@RequestBody Guest guest) {
        try {
            Guest guest1 = hotelManagementSystemService.addGuest(guest);
            GuestResponseDTO guestResponseDTO = new GuestResponseDTO();
            guestResponseDTO.setId(2000L);
            guestResponseDTO.setStatusMessage("Guest Added Successfully");
            guestResponseDTO.setGuest(guest1);
            return guestResponseDTO;
        } catch (InvalidDataException ex) {
            GuestResponseDTO guestResponseDTO = new GuestResponseDTO();
            guestResponseDTO.setId(ex.getId());
            guestResponseDTO.setStatusMessage(ex.getStatusMessage());
            return guestResponseDTO;
        }
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
    public ReservationResponseDTO cancelReservation(@PathVariable String reservationId) {
        Long rId = Long.parseLong(reservationId);
        try {
            hotelManagementSystemService.cancelReservation(rId);
            ReservationResponseDTO response = new ReservationResponseDTO();
            response.setStatusCode(2000L);
            response.setStatusMessage("Reservation Cancelled SuccessFullly");
            return response;
        } catch (ReservationException ex) {
            ReservationResponseDTO response = new ReservationResponseDTO(ex.getId(),
                    ex.getStatusMessage());
            return response;
        }
    }
}
