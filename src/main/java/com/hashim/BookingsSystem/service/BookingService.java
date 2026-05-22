package com.hashim.BookingsSystem.service;

import com.hashim.BookingsSystem.exception.GuestCapacityException;
import com.hashim.BookingsSystem.model.Booking;
import com.hashim.BookingsSystem.model.Room;
import com.hashim.BookingsSystem.repository.BookingRepository;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking addBooking(Booking booking) throws IllegalArgumentException
    {
        if (booking.getRoomType().getCapacity() < booking.getNumberOfGuests())
            throw new GuestCapacityException("The number of guests should not be less that 0 or exceeds "
                    + booking.getRoomType().getCapacity() );

        booking.setTotalPrice(booking.getRoomType().getPrice());
        this.bookingRepository.save(booking);
        return booking;
    }

    public Map<String, Integer> getAllRooms()
    {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Enkelrum", Room.ENKEL.getNumberOfRooms());
        map.put("Ledig enkelrum", Room.ENKEL.getNumberOfRooms() - bookingRepository.countByRoomType(Room.ENKEL));
        map.put("Dubbelrum", Room.DUBBEL.getNumberOfRooms());
        map.put("Ledig dubbelrum", Room.DUBBEL.getNumberOfRooms() - bookingRepository.countByRoomType(Room.DUBBEL));
        map.put("Svit",  Room.SVIT.getNumberOfRooms());
        map.put("Ledig svit", Room.SVIT.getNumberOfRooms() - bookingRepository.countByRoomType(Room.SVIT));

        return map;
    }

    public List<Booking> findAllBookings()
    {
        return bookingRepository.findAll();
    }

}
