package com.senla.application;

import com.senla.entity.*;
import com.senla.facade.AdministratorService;
import com.senla.service.RoomService;
import com.senla.service.ServiceOfServices;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
    public void initialize(){

        AdministratorService administratorService = new AdministratorService();

      /*  Room room = new Room(1,20, 3, 2); // параметры
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
        administratorService.checkAllClients();*/


        Room room = new Room(2,3,4,5, true, false);
        administratorService.addRoom(room);
        Service service = new Service("Bar", 200);
        administratorService.addService(service);
        Client client = new Client("Tom", 2);
        administratorService.addClient(room, client);

      Room room2 = new Room(3,4,5,6, true, false);
      administratorService.addRoom(room2);
      Service service2 = new Service("Massage", 100);
      administratorService.addService(service2);
      Client client1 = new Client("Jhon", 3);
      administratorService.addClient(room2,client1);

      administratorService.checkAllRooms();
      administratorService.checkAllServices();
      administratorService.checkAllClients();

      administratorService.removeRoom(2);
      administratorService.removeClient("Tom", room);
      administratorService.removeService("Bar");

        administratorService.checkAllRooms();
        administratorService.checkAllServices();
        administratorService.checkAllClients();
    }
}