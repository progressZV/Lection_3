package com.senla.service;

import com.senla.dao.*;
import com.senla.entity.*;

import java.util.List;

public class RoomService {

    // private IRoomDao roomDao = new FileRoomDao(new FileStreamWriter("Rooms.txt"), new FileStreamReader("Rooms.txt"), new Parser());
    private IRoomDao iroomDao = new JDBCRoomDao();


    public void addRoom(Room room) {
        var room1 = iroomDao.getRooms().stream().filter(r -> r.getNumber() == room.getNumber()).findFirst();
        if (room1.isPresent()) {
            System.out.println("Room with this number already exists.");
            return;
        }
        iroomDao.saveRoom(room);
        System.out.println("Room " + room.getNumber() + " was added successfully.");
    }

    public void changeFreeStatus(Integer id, boolean status) {
        var room1 = iroomDao.getRooms().stream().filter(r -> r.getNumber() == id).findFirst().orElse(null);
        if (room1 == null) {
            System.out.println("Can't find the room.");
            return;
        }

        iroomDao.changeFreeStatus(id, status);
        System.out.println("Status changed for Room №" + id);
    }

    public void deleteRoom(int number) {
        Room room =  iroomDao.getRooms().stream().filter(r -> r.getNumber() == number).findFirst().orElse(null);
        if (room == null) {
            System.out.println("Can't find the room.");
            return;
        }
        if (!room.getFreeStatus()) {
            System.out.println("This room has a client in.");
            return;
        }

        iroomDao.deleteRoom(String.valueOf(number));

        System.out.println("Room " + room.getNumber() + " was removed successfully.");
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = iroomDao.getRooms();
        for (Room room : rooms) {
            System.out.println(room.convertToString());
        }
        return rooms;
    }

    public void changeCostRoom(Integer id, double cost) {
        var room1 =  iroomDao.getRooms().stream().filter(r -> r.getNumber() == id).findFirst().orElse(null);
        if (room1 == null) {
            System.out.println("Can't find the room.");
            return;
        }
        if (room1.getCost() == cost) {
            System.out.println("We have already this cost.");
            return;
        }
        iroomDao.changeCostRoom(id, cost);
        System.out.println("Cost changed for Room №" + id);
    }

    public void changeFixStatus(Integer id, boolean fixStatus) {
        var room1 =  iroomDao.getRooms().stream().filter(r -> r.getNumber() == id).findFirst().orElse(null);
        if (room1 == null) {
            System.out.println("Can't find the room.");
            return;
        }
        if (room1.getFixStatus() == fixStatus) {
            System.out.println("We have already this status.");
            return;
        }
        if(!room1.getFreeStatus()) {
            System.out.println("We have a client in.");
            return;
        }


       iroomDao.changeFixStatus(id, fixStatus);
        System.out.println("Status changed for Room №" + id);
    }
}
