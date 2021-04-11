package com.senla.service;

import com.senla.entity.Hotel;

public class UserService {

    private final RoomService roomService;

    public UserService(RoomService roomService){
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
                return roomService.changeCost(Hotel.getHotel(), Hotel.getServices());
            case 5:
                return roomService.createNewRoomOrService(Hotel.getHotel(), Hotel.getServices());
            case 6:
                return roomService.listNumbers(Hotel.getHotel());
            case 7:
                return null;
            default:
                return "Некорректный ввод.";
        }
    }
}
