package com.senla.service;

import com.senla.dao.RoomRepository;
import com.senla.entity.Room;
import com.senla.exception.GlobalException;
import com.senla.model.RoomDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void addRoom(Room room) {
        var room1 = getAllRooms().stream().filter(r -> r.getNumber() == room.getNumber() || r.getId().equals(room.getId())).findFirst();
        if (room1.isPresent()) {
           throw new GlobalException("Room is already exist.");
        }
        roomRepository.save(room);
    }

    public RoomDTO getRoom(int number){
        var room = roomRepository.getByNumber(number);
        if (room == null) {
            throw new GlobalException("Room is not founded.");
        }
        return RoomDTO.toModel(room);
    }

    public Room updateRoom(Integer roomFromDbNumber, Room room){
        var roomFromDb = roomRepository.getByNumber(roomFromDbNumber);
        if (roomFromDb == null) {
            throw new GlobalException("Room is not founded.");
        }
            BeanUtils.copyProperties(room, roomFromDb, "id", "number");
         return roomRepository.save(roomFromDb);
    }

    public void deleteRoom(int number) {
        Room room = getAllRooms().stream().filter(r -> r.getNumber() == number).findFirst().orElse(null);
        if (room == null) {
            throw new GlobalException("Room is not founded.");
        }
        if(!room.isFreeStatus()) {
            throw new GlobalException("We have a client in the room.");
        }
        roomRepository.delete(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

}
