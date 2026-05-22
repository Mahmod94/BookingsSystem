package com.hashim.BookingsSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;


@Entity
public class Booking {


    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Guest name is required")
    @Size(min = 2, message = "The guest name cannot be less than 2 characters")
    private String guestName;
    @NotNull
    private Room roomType;
    @NotNull
    @Min(value = 1,message = "Number of guests should at least be 1")
    @Max(value = 3, message = "Number of guests cannot exceed 3")
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

    public Room getRoomType() {
        return roomType;
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
