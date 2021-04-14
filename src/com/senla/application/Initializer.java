package com.senla.application;

import com.senla.entity.*;
import com.senla.facade.AdministratorService;

public class Initializer {
    public void initialize(){
        AdministratorService administratorService = new AdministratorService();

        Room room = new Room(1,20, 3, 2); // параметры
        administratorService.addRoom(room) ;
        Service service = new Service("Бар", 200); // параметры
        administratorService.addService(service);

        Room room1 = new Room(2,45, 4, 3);
        administratorService.addRoom(room1);
        Service service1 = new Service("Массаж", 50);
        administratorService.addService(service1);

        Client client = new Client("Mark");
        administratorService.addClient(room1, client);


        administratorService.checkAllRooms();
        administratorService.checkAllServices();
        administratorService.checkAllClients();

        administratorService.changeFixStatus(room1);
        administratorService.removeService("Бар");
        administratorService.removeRoom(1);
        administratorService.removeClient("Mark", room1);
        administratorService.changeCostRoom(room1, 15);

        administratorService.checkAllRooms();
        administratorService.checkAllServices();
        administratorService.checkAllClients();
    }
}