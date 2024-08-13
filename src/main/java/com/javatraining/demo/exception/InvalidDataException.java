package com.javatraining.demo.exception;

public class InvalidDataException extends RuntimeException {
    private Long id;
    private String statusMessage;

    public InvalidDataException(Long id, String statusMessage) {
        this.id = id;
        this.statusMessage = statusMessage;
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
}
