package com.javatraining.demo.controller;

import com.javatraining.demo.dto.GuestResponseDTO;
import com.javatraining.demo.exception.InvalidDataException;
import com.javatraining.demo.exception.ReservationException;
import com.javatraining.demo.exception.SqlException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionBaseController {

    @ExceptionHandler(InvalidDataException.class)
    public Map<String, Object> invalidDataException(InvalidDataException exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", exception.getId());
        map.put("statusMessage", exception.getStatusMessage());
        return map;
    }

    @ExceptionHandler(ReservationException.class)
    public ReservationException reservationException(ReservationException exception) {
        return exception
    }

    @ExceptionHandler(SqlException.class)
    public SqlException sqlException(SqlException exception) {
        return exception;
    }
}
