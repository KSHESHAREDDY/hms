package com.javatraining.demo.service;

import com.javatraining.demo.common.ReservationStatus;
import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.domain.Reservation;
import com.javatraining.demo.domain.Room;
import com.javatraining.demo.dto.ReservationRequestDTO;
import com.javatraining.demo.respository.GuestRepository;
import com.javatraining.demo.respository.ReservationRepository;
import com.javatraining.demo.respository.RoomRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelManagementSystemServiceImpl implements HotelManagementSystemService {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepositroy roomRepositroy;

    @Override
    public void addGuest(Guest guest) {
        guestRepository.save(guest);
    }

    @Override
    public Reservation makeReservation(ReservationRequestDTO reservationRequestDTO) {
        Guest guest = guestRepository.findById(reservationRequestDTO.getGuestId()).orElse(null);
        Room room = roomRepositroy.findById(reservationRequestDTO.getRoomId()).orElse(null);
        Reservation reservation = new Reservation();
        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setCheckInDate(reservationRequestDTO.getCheckInDate());
        reservation.setCheckOutDate(reservationRequestDTO.getCheckOutDate());
        reservation.setReservationStatus(reservationRequestDTO.getStatus());
        Reservation updatedRecord = reservationRepository.save(reservation);
        return updatedRecord;
    }

    @Override
    public void cancelReservation(Long rId) {
        reservationRepository.updateReservationStatusById(rId, ReservationStatus.CANCELLED);
    }

}
