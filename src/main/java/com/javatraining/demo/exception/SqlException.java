package com.javatraining.demo.exception;

public class SqlException extends RuntimeException{
    Long id;
    String StatusMessage;

    public SqlException(Long id, String statusMessage) {
        this.id = id;
        StatusMessage = statusMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatusMessage() {
        return StatusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        StatusMessage = statusMessage;
    }
}
