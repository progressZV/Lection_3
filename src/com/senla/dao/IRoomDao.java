package com.senla.dao;

import com.senla.entity.Room;

import java.util.List;

public interface IRoomDao{
    void saveRoom(Room room);
    void deleteRoom(String str);
    List<Room> getRooms();
    void changeCostRoom(Room room);
    void changeFixStatus(Room room);
}
