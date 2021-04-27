package com.senla.dao;

import com.senla.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class FileRoomDao implements IRoomDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;
    private final Parser parser;

    public FileRoomDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader, Parser parser){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
        this.parser = parser;
    }

    @Override
    public void saveRoom(Room room) {
        fileStreamWriter.write(room.toString(), true);
    }

    @Override
    public void deleteRoom(String str) {
        fileStreamWriter.write(str, false);
    }

    @Override
    public List<Room> getRooms(){ // добавить статусы
       String fileData = fileStreamReader.readFile();
       return parser.convertToRoom(fileData);
    }

    @Override
    public void changeCostRoom(Room room) {

    }

    @Override
    public void changeFixStatus(Room room) {

    }
}
