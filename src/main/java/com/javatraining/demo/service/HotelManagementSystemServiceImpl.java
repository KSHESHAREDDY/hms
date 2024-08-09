package com.javatraining.demo.service;

import com.javatraining.demo.domain.Guest;
import com.javatraining.demo.respository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelManagementSystemServiceImpl implements HotelManagementSystemService {

    @Autowired
    GuestRepository guestRepository;

    @Override
    public void addGuest(Guest guest) {
        guestRepository.save(guest);
    }

    @Override
    public Guest getGuest(Long id) {
        return null;
    }

    @Override
    public void addGuests(List<Guest> guests) {
        guestRepository.saveAll(guests);
    }

    @Override
    public Guest getGuestByEmailId(String emailId) {
        return guestRepository.findGuestByEmail(emailId);
    }

    @Override
    public Guest getGuestByEmailIdAndPhoneNumber(String emailId, Long phoneNumber) {
        return guestRepository.findGuestByEmailAndPhoneNumber(emailId, phoneNumber);
    }
}
