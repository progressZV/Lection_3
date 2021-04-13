package com.senla.dao;

import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRoomDao implements IRoomDao{

    private final List<Room> rooms = new ArrayList<>();
    private final FileStreamWriter fileStreamWriter = new FileStreamWriter("Hotel.txt");
    private final FileStreamReader fileStreamReader = new FileStreamReader();

    @Override
    public void saveRoom(Room room) {
        for (Room room1 : rooms) {
            if (room.getNumber() != room1.getNumber() && room.getFreeStatus() && !room.getFixStatus()) {
                rooms.add(room);
                fileStreamWriter.write("Добавление комнаты №" + room.getNumber() + " с ценой:" + room.getCost() + "прошло успешно.");
            } else if (room.getNumber() == room1.getNumber() && !room.getFreeStatus()) {
                System.out.println("Номер занят");
            }
        }
        System.out.println("Данного номера не существует.");
    }

    @Override
    public void deleteRoom(int number) {
        for(Room room : rooms){
            if (room.getNumber() == number)
                rooms.remove(room);
            fileStreamWriter.write("Удаление комнаты №" + room.getNumber() + " с ценой:" + room.getCost() + "прошло успешно.");
        }
    }

    @Override
    public List<Room> getList(){
        for(Room room : rooms){
            fileStreamWriter.write("Список номеров:" + "\n");
            fileStreamWriter.write(room.toString() + "\n");
        }
        return rooms;
    }

    @Override
    public void saveService(Service service) {

    }
}
