package com.hashim.BookingsSystem.controller;

import com.hashim.BookingsSystem.model.Booking;
import com.hashim.BookingsSystem.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookingController {

    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/api/rooms")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Map<String, Integer> getAllRooms()
    {
        return bookingService.getAllRooms();
    }

    @GetMapping("/api/bookings")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Booking> getAll()
    {
        return bookingService.findAllBookings();
    }

    @PostMapping("/api/bookings")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Booking> postBooking(@Valid @RequestBody Booking booking){
        bookingService.addBooking(booking);
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/api/bookings/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteBooking(@Valid @PathVariable int id)
    {
        Booking booking = bookingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
