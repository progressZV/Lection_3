package com.senla.application;

import com.senla.entity.*;
import com.senla.service.AdministratorService;

public class Initializer {
    public void initialize() {
        AdministratorService administratorService = new AdministratorService();

        Room room = new Room(); // параметры
        administratorService.addRoom(room);
        Service service = new Service(); // параметры
        administratorService.addService(service);
    }
}