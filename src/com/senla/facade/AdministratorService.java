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

    public void addClient(Room room, Client client) {
        boolean freeRoomStatus;
        freeRoomStatus = clientService.addClient(room, client);
        if(freeRoomStatus)
        roomService.changeFreeStatus(room, false);
    }

    public void removeClient(String name, Room room) {
        boolean freeRoomStatus;
        freeRoomStatus = clientService.removeClient(name, room);
        if(!freeRoomStatus)
            roomService.changeFreeStatus(room, true);
    }

    public void checkAllRooms() { roomService.getAllRooms(); }

    public void checkAllServices() { service.getAllServices(); }

    public void checkAllClients() { clientService.getClients(); }

    public void changeCostRoom(Room room, double cost) { roomService.changeCostRoom(room, cost); }

    public void changeFixStatus(Room room, boolean fixStatus) { roomService.changeFixStatus(room, fixStatus); }

    public void changeFreeStatus(Room room, boolean status) { roomService.changeFreeStatus(room,status); }

    public void changeCostService(Service service1, double cost) { service.changeCostService(service1, cost); }

}
