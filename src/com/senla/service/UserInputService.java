package com.senla.service;

import com.senla.entity.Hotel;

public class UserInputService {

    private final RoomService roomService;

    public UserInputService(RoomService roomService){
        this.roomService = roomService;
    }
    public String menu(int c1){
        switch (c1){
            case 1:
                return roomService.putInTheRoom(Hotel.getHotel());
            case 2:
                return roomService.removeFromRoom(Hotel.getHotel());
            case 3:
                return roomService.changeFixStatus(Hotel.getHotel());
            case 4:
                return roomService.changeCost(Hotel.getHotel());
            case 5:
                return roomService.createNewRoom(Hotel.getHotel());
            case 6:
                return null;
            default:
                return "Некорректный ввод.";
        }
    }
}
