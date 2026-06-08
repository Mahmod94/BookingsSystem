package com.hashim.BookingsSystem.exception;

public class GuestCapacityException extends RuntimeException{

    public GuestCapacityException(String message){
        super(message);
    }

    public GuestCapacityException() {
        super("The number of guests is incompatible with the rooms capacity");
    }
}
