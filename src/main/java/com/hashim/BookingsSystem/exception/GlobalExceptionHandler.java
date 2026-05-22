package com.hashim.BookingsSystem.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hashim.BookingsSystem.model.ErrorResponse;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationsExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : e.getBindingResult().getFieldErrors())
            errors.put(error.getField(), error.getDefaultMessage());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(GuestCapacityException.class)
    public ResponseEntity<ErrorResponse> handleGuestCapacityException(GuestCapacityException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(400, e.getMessage()));
    }


    @ExceptionHandler(RoomFullyBookedException.class)
    public ResponseEntity<ErrorResponse> handleRoomFullyBooked(RoomFullyBookedException e){
        return ResponseEntity.badRequest().body(new ErrorResponse(400, e.getMessage()));
    }

    @ExceptionHandler(BookingNotFountException.class)
    public ResponseEntity<ErrorResponse> handleBookingNotFound(BookingNotFountException e)
    {
        return ResponseEntity.badRequest().body(new ErrorResponse(404, e.getMessage()));
    }

}
