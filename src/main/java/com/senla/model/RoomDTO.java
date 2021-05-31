package com.senla.model;

import com.senla.entity.Room;

public class RoomDTO {
    private int number;
    private double cost;
    private int stars_count;
    private int rooms_count;

    public static RoomDTO toModel(Room room){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setNumber(room.getNumber());
        roomDTO.setCost(room.getCost());
        roomDTO.setStars_count(room.getStarsCount());
        roomDTO.setRooms_count(room.getRoomsCount());
        return roomDTO;
    }

    public int getNumber() {
        return number;
    }

    public double getCost() {
        return cost;
    }

    public int getStars_count() {
        return stars_count;
    }

    public int getRooms_count() {
        return rooms_count;
    }

    public RoomDTO(){
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setStars_count(int stars_count) {
        this.stars_count = stars_count;
    }

    public void setRooms_count(int rooms_count) {
        this.rooms_count = rooms_count;
    }
}
