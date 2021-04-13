package com.senla.dao;

import com.senla.entity.Room;

public class FileRoomDao implements IRoomDao{

    private final FileStreamWriter fileStreamWriter = new FileStreamWriter("Hotel.txt");
    private final FileStreamReader fileStreamReader = new FileStreamReader();

    @Override
    public void saveRoom(Room room) {
        fileStreamWriter.write(room.toString() + "\n");
    }

    @Override
    public void deleteRoom(int number) {
        fileStreamWriter.write("Комната с номером " + number + " удалена." + "\n");
    }

    @Override
    public void getList(String str){
       fileStreamWriter.write(str + "\n");
    }
}
