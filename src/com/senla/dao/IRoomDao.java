package com.senla.dao;

import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.List;

public interface IRoomDao{
    void saveRoom(Room room);
    void deleteRoom(int number);
    List<Room> getList();
    void saveService(Service service);
}
