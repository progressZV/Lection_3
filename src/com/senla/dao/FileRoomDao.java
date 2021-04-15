package com.senla.dao;

import com.senla.entity.Room;

public class FileRoomDao implements IRoomDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public FileRoomDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    @Override
    public void saveRoom(Room room) {
        fileStreamWriter.write(room.toString() + "\n");
    }

    @Override
    public void deleteRoom(int number) {
       String str =  fileStreamReader.readFile();
       System.out.println(str);
    }

    @Override
    public void getList(String str){
        str = fileStreamReader.readFile();
    }

    @Override
    public void changeCostRoom(Room room) {
        fileStreamWriter.write("Изменение цены комнаты:" + "\n");
        fileStreamWriter.write("Изменена цена номера " + room.getNumber() + " на " + room.getCost() + "\n" + "\n");
    }

    @Override
    public void changeFixStatus(Room room) {
        fileStreamWriter.write("Изменение статуса номера:" + "\n");
        if(room.getFixStatus())
        fileStreamWriter.write("Изменён статус номера на ремонтируемый." + "\n");
        else fileStreamWriter.write("Изменён статус номера на обслуживаемый." + "\n");
    }
}
