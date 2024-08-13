package com.javatraining.demo.service;

import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.domain.Reservation;
import com.javatraining.demo.dto.ReservationRequestDTO;

import java.util.List;

public interface HotelManagementSystemService {
    void addGuest(Guest guest);

    Reservation makeReservation(ReservationRequestDTO reservationRequestDTO);

    void cancelReservation(Long rId);
}
