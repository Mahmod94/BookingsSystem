package com.hashim.BookingsSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Integer id;

    private String guestName;
    private String roomType;
    private Integer numberOfGuests;
    private Double totalPrice;


    public Booking(Integer id, String guestName, String roomType, Integer numberOfGuests, Double totalPrice) {
        this.id = id;
        this.guestName = guestName;
        this.roomType = roomType;
        this.numberOfGuests = numberOfGuests;
        this.totalPrice = totalPrice;
    }

    public Booking() {
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" + "Guest Name: " + guestName + "\n"
                + "roomType: " + roomType + "\nNumber of guests: " + numberOfGuests
                 + "\nTotal price: " + totalPrice;
    }
}
