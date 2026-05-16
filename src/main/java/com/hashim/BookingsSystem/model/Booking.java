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
    private Room roomType;
    private Integer numberOfGuests;
    private Integer totalPrice;


    public Booking(Integer id, String guestName, Room roomType, Integer numberOfGuests, Integer totalPrice) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomType() {
        return roomType.toString();
    }


    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }


}
