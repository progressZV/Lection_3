package com.senla.dao;

import com.senla.entity.Room;

public interface IRoomDao{
    void saveRoom(Room room);
    void deleteRoom(int number);
    void getList(String str);
    void changeCostRoom(Room room);
    void changeFixStatus(Room room);
}
