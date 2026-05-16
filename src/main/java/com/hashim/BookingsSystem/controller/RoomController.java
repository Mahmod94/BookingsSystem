package com.hashim.BookingsSystem.controller;

import com.hashim.BookingsSystem.model.Booking;
import com.hashim.BookingsSystem.model.Room;
import com.hashim.BookingsSystem.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    private BookingRepository bookingRepository;

    public RoomController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/rooms")
    public String getAllRooms()
    {
        return "Enkel rum: " + Room.ENKEL.getNumberOfRooms().toString()
                +"\nDubbel rum: " + Room.DUBBEL.getNumberOfRooms() +
                "\nSvit rum: " + Room.SVIT.getNumberOfRooms();
    }

    @GetMapping("/booking")
    public List<Booking> getAll()
    {
        return bookingRepository.findAll();
    }

    @PostMapping("/booking")
    public String postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return booking.toString();
    }
}
