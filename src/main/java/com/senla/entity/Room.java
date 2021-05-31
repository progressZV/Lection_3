package com.senla.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 1, message = "Please enter the correct number of the room.")
    @NotNull(message = "Please enter the number of the room.")
    private int number;

    private boolean freeStatus = true;
    private boolean fixStatus = false;

    @Min(value = 1, message = "Please enter the correct cost of the room.")
    @NotNull(message = "Please enter the cost of the room.")
    private double cost;

    @Min(value = 1, message = "Please enter the correct number of room stars.")
    @NotNull(message = "Please enter the number of stars.")
    private int starsCount;

    @Min(value = 1, message = "Please enter the correct number of rooms.")
    @NotNull(message = "Please enter the number of rooms.")
    private int roomsCount;


    public Room(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFreeStatus(boolean freeStatus) {
        this.freeStatus = freeStatus;
    }

    public void setFixStatus(boolean fixStatus) {
        this.fixStatus = fixStatus;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFreeStatus() {
        return freeStatus;
    }

    public boolean isFixStatus() {
        return fixStatus;
    }

    public double getCost() {
        return cost;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    @Override
    public String toString(){
        return getNumber() + "\t" +
                getCost() + "\t" + getRoomsCount() +
                "\t" + getStarsCount() + "\t" + isFreeStatus() + "\t" + isFixStatus() + "\n";
    }
}
