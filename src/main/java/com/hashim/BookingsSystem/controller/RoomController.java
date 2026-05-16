package com.hashim.BookingsSystem.controller;

import com.hashim.BookingsSystem.model.Booking;
import com.hashim.BookingsSystem.repository.BookingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private BookingRepository bookingRepository;

    public RoomController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/booking")
    public List<Booking> getAll()
    {
        return bookingRepository.findAll();
    }

    @PostMapping("/booking")
    public String postBooking(@RequestParam Booking booking){
        bookingRepository.save(booking);
        return booking.toString();
    }
}
