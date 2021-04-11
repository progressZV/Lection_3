package com.senla.dao;

import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.List;

public class FileRoomDao implements IRoomDao{

    private final FileStreamWriter fileStreamWriter = new FileStreamWriter();
    private final FileStreamReader fileStreamReader = new FileStreamReader();

    @Override
    public void saveRoom(Room room) {

    }

    @Override
    public void deleteRoom(int id) {

    }

    @Override
    public List<Room> getList() {
        return null;
    }

    @Override
    public void saveService(Service service) {

    }
}
