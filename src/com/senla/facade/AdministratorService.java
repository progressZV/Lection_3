package com.senla.facade;

import com.senla.entity.*;
import com.senla.service.ClientService;
import com.senla.service.RoomService;
import com.senla.service.ServiceOfServices;

import java.util.List;

public class AdministratorService {
    private RoomService roomService = new RoomService();
    private ServiceOfServices service = new ServiceOfServices();
    private ClientService clientService = new ClientService();

    public void addRoom(Room room) {
        roomService.addRoom(room);
    }

    public void addService(Service _service) {
        service.addService(_service);
    }

    public void removeRoom(int number){ roomService.deleteRoom(number); }

    public void removeService(String name) { service.deleteService(name);}

    public void addClient(Room room, Client client) { clientService.addClient(room, client); }

    public void removeClient(String name, Room room) { clientService.removeClient(name, room); }

    public void checkAllRooms() { roomService.getAllRooms(); }

    public void checkAllServices() { service.getAllServices(); }

    public void checkAllClients() { clientService.getClients(); }

  //  public void changeCostRoom(Room room, double cost) { roomService.changeCostRoom(room, cost); }

    public void changeFixStatus(Room room) { roomService.changeFixStatus(room); }

}
