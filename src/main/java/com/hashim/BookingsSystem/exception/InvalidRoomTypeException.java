package com.hashim.BookingsSystem.exception;

public class InvalidRoomTypeException extends RuntimeException{

    public InvalidRoomTypeException(String message){
        super(message);
    }

    public InvalidRoomTypeException() {
        super("Please provide a valid room type!");
    }
}