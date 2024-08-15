package com.javatraining.demo.dto;

import com.javatraining.demo.domain.Guest;

public class GuestResponseDTO {
    Long id;
    String statusMessage;
    Guest guest;

    public GuestResponseDTO() {
    }

    public GuestResponseDTO(Long id, String statusMessage, Guest guest) {
        this.id = id;
        this.statusMessage = statusMessage;
        this.guest = guest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
