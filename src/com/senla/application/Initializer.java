package com.senla.application;

import com.senla.entity.*;
import com.senla.service.AdministratorService;

public class Initializer {
    public void initialize() throws  Exception{
        AdministratorService administratorService = new AdministratorService();

        Room room = new Room(1,20); // параметры
        administratorService.addRoom(room) ;
        Service service = new Service("Бар", 200); // параметры
        administratorService.addService(service);
    }
}