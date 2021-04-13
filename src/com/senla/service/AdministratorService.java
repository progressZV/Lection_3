package com.senla.service;

import com.senla.entity.*;

public class AdministratorService {
    private RoomService roomService = new RoomService();
    private ServiceOfServices service = new ServiceOfServices();
    private UserService userService = new UserService();





    public void addRoom(Room room) {
        roomService.addRoom(room);
    }

    public void addService(Service _service) {
        service.addService(_service);
    }
}
