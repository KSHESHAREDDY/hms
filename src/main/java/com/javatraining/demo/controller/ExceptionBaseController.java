package com.javatraining.demo.controller;

import com.javatraining.demo.dto.GuestResponseDTO;
import com.javatraining.demo.exception.InvalidDataException;
import com.javatraining.demo.exception.ReservationException;
import com.javatraining.demo.exception.SqlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionBaseController {

    @ExceptionHandler({InvalidDataException.class, ReservationException.class, SqlException.class})
    public ResponseEntity invalidDataException(InvalidDataException exception) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", exception.getId());
        response.put("message", exception.getStatusMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
