package com.hashim.BookingsSystem.exception;

public class RoomFullyBookedException extends RuntimeException{

    public RoomFullyBookedException() {
        super("The rooms are fully booked!");
    }

    public RoomFullyBookedException(String message){
        super(message);
    }
}