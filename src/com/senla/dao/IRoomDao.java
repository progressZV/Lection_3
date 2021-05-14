package com.senla.dao;

import com.senla.entity.Room;

import java.util.List;

public interface IRoomDao{
    void saveRoom(Room room);
    void deleteRoom(String str);
    List<Room> getRooms();
    void changeCostRoom(Integer number, double cost);
    void changeFixStatus(Integer number, boolean fix_status);
    void changeFreeStatus(Integer number, boolean free_status);
}
