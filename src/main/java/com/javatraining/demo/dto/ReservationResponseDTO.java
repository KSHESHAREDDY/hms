package com.javatraining.demo.dto;

import com.javatraining.demo.domain.Reservation;

public class ReservationResponseDTO {
    private Long statusCode;
    private String statusMessage;
    private Reservation reservation;

    public ReservationResponseDTO(Long statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public ReservationResponseDTO(Long statusCode, String statusMessage, Reservation reservation) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.reservation = reservation;
    }

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
