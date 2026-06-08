package com.hashim.BookingsSystem.model;

public enum Room {
    ENKEL("Enkel", 500, 1, 10),
    DUBBEL("Dubbel", 1000, 2, 7),
    SVIT("Svit", 2000, 3, 3);


    private final String type;
    private final Integer price;
    private final Integer capacity;
    private final Integer numberOfRooms;


    Room(String type, Integer price, Integer capacity, Integer numberOfRooms) {
        this.type = type;
        this.price = price;
        this.capacity = capacity;
        this.numberOfRooms = numberOfRooms;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

}
