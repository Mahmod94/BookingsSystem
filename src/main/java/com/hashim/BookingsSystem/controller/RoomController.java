package com.hashim.BookingsSystem.controller;

import com.hashim.BookingsSystem.model.Booking;
import com.hashim.BookingsSystem.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RoomController {

    BookingService bookingService;

    public RoomController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping("/rooms")
    public Map<String, Integer> getAllRooms()
    {
        return bookingService.getAllRooms();
    }

    @GetMapping("/bookings")
    public List<Booking> getAll()
    {
        return bookingService.findAllBookings();
    }

    @PostMapping("/bookings")
    public Booking postBooking(@Valid @RequestBody Booking booking){
        return bookingService.addBooking(booking);
    }
}
