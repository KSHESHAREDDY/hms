package com.javatraining.demo.service;

import com.javatraining.demo.domain.Guest;

import java.util.List;

public interface HotelManagementSystemService {
    void addGuest(Guest guest);
    Guest getGuest(Long id);
    void addGuests(List<Guest> guests);

    Guest getGuestByEmailId(String emailId);

    Guest getGuestByEmailIdAndPhoneNumber(String emailId, Long phoneNumber);
}
