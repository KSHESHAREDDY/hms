package com.javatraining.demo.service;

import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.domain.Reservation;
import com.javatraining.demo.dto.ReservationRequestDTO;
import com.javatraining.demo.exception.InvalidDataException;
import com.javatraining.demo.exception.ReservationException;
import com.javatraining.demo.exception.SqlException;

import java.util.List;

public interface HotelManagementSystemService {
    Guest addGuest(Guest guest) throws InvalidDataException;

    Reservation makeReservation(ReservationRequestDTO reservationRequestDTO) throws SqlException;

    void cancelReservation(Long rId) throws ReservationException;
}
