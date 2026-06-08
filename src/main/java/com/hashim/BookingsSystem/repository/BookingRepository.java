package com.hashim.BookingsSystem.repository;

import com.hashim.BookingsSystem.model.Booking;
import com.hashim.BookingsSystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Integer countByRoomType(Room RoomType);


}
