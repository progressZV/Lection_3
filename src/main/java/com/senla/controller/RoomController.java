package com.senla.controller;


import com.senla.entity.Room;
import com.senla.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("room")
public class RoomController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> list() {
        logger.info("List of the rooms.");
        return roomService.getAllRooms();
    }

    @GetMapping("{id}")
    public ResponseEntity getRoom(@PathVariable("id") Integer number) {
        logger.info("Get room № "+ number);
            return ResponseEntity.ok(roomService.getRoom(number));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid Room room) {
        logger.info("Create room ("+ room + ")");
        roomService.addRoom(room);
        return ResponseEntity.ok("Room is added.");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable("id") Integer number, @RequestBody @Valid Room room) {
        logger.info("Update room № "+ number);
        roomService.updateRoom(number, room);
        return ResponseEntity.ok("Room is updated.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> remove(@PathVariable("id") Integer number){
        logger.info("Delete room with number: "+ number);
            roomService.deleteRoom(number);
            return ResponseEntity.ok("Room is removed.");
    }
}
