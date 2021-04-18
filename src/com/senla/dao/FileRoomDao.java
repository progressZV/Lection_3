package com.senla.dao;

import com.senla.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class FileRoomDao implements IRoomDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public FileRoomDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    @Override
    public void saveRoom(Room room) {
        fileStreamWriter.write(room.toString());
    }

    @Override
    public void deleteRoom(String str) {
        fileStreamWriter.write(str);
    }

    @Override
    public List<Room> getRooms(){ // добавить статусы
       String fileData = fileStreamReader.readFile();
        List<Room> rooms = new ArrayList<>();
        if(!fileData.isEmpty()) {
       // String[] ary = fileData.split("TABTAB" );
        String[] ary = fileData.split("\n");
            for (int i = 0; i < ary.length; i++) { //check
                String[] words = ary[i].split("\t");
                for(int j = 0; j< words.length; j++)
                words[j] = words[j].trim();
                rooms.add(new Room(Integer.parseInt(words[0]), Double.parseDouble(words[1]), Integer.parseInt(words[2]), Integer.parseInt(words[3])));
            }
        }
       return rooms;
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
