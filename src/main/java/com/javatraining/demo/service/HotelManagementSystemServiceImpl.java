package com.javatraining.demo.service;

import com.javatraining.demo.common.ReservationStatus;
import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.domain.Reservation;
import com.javatraining.demo.domain.Room;
import com.javatraining.demo.dto.ReservationRequestDTO;
import com.javatraining.demo.exception.InvalidDataException;
import com.javatraining.demo.exception.ReservationException;
import com.javatraining.demo.exception.SqlException;
import com.javatraining.demo.respository.GuestRepository;
import com.javatraining.demo.respository.ReservationRepository;
import com.javatraining.demo.respository.RoomRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class HotelManagementSystemServiceImpl implements HotelManagementSystemService {

    @Autowired
    GuestRepository guestRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepositroy roomRepositroy;

    @Override
    public Guest addGuest(Guest guest) throws InvalidDataException {
        if(guest != null && guest.getEmail() != null && guest.getName() != null){
            return guestRepository.save(guest);
        } else {
            throw new InvalidDataException(1000L, "Guest Data Is invalid Please Send Valid Data");
        }
    }

    @Override
    public Reservation makeReservation(ReservationRequestDTO reservationRequestDTO) throws SqlException {
        try {
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
        } catch (Exception exception) {
            throw new SqlException(2000L, "Invalid Data Exception");
        }
    }

    @Override
    public void cancelReservation(Long rId) throws ReservationException {
        try {
            reservationRepository.updateReservationStatusById(rId, ReservationStatus.CANCELLED);
        } catch(Exception ex) {
            throw new ReservationException(3000L, "Reservation id should Present");
        }
        
    }

}
