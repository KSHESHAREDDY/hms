package com.javatraining.demo.controller;

import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.domain.Reservation;
import com.javatraining.demo.dto.GuestResponseDTO;
import com.javatraining.demo.dto.ReservationRequestDTO;
import com.javatraining.demo.dto.ReservationResponseDTO;
import com.javatraining.demo.service.HotelManagementSystemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/hms")
public class HotelManagementSystemController {

    @Autowired
    HotelManagementSystemService hotelManagementSystemService;

    @PostMapping(path = "/addGuest", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GuestResponseDTO addGuest(@RequestBody Guest guest) {
        Guest guest1 = hotelManagementSystemService.addGuest(guest);
        GuestResponseDTO guestResponseDTO = new GuestResponseDTO();
        guestResponseDTO.setId(2000L);
        guestResponseDTO.setStatusMessage("Guest Added Successfully");
        guestResponseDTO.setGuest(guest1);
        return guestResponseDTO;
    }

    @PostMapping(path = "/reservation")
    public ReservationResponseDTO bookRoom(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = hotelManagementSystemService.makeReservation(reservationRequestDTO);
        ReservationResponseDTO response = new ReservationResponseDTO(200L,
                "Reservation Created Successfully");
        response.setReservation(reservation);
        return response;
    }

    @PutMapping(path = "/cancel/{reservationId}")
    public ReservationResponseDTO cancelReservation(@PathVariable String reservationId) {
        Long rId = Long.parseLong(reservationId);
        hotelManagementSystemService.cancelReservation(rId);
        ReservationResponseDTO response = new ReservationResponseDTO();
        response.setStatusCode(2000L);
        response.setStatusMessage("Reservation Cancelled SuccessFullly");
        return response;
    }
}
