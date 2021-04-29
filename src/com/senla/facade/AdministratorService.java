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

    public void addClient(Integer roomID, Client client) {
        boolean freeRoomStatus;
        freeRoomStatus = clientService.addClient(roomID, client);
        if(freeRoomStatus)
        roomService.changeFreeStatus(roomID, false);
    }

    public void removeClient(String name, Integer roomID) {
        boolean freeRoomStatus;
        freeRoomStatus = clientService.removeClient(name, roomID);
        if(freeRoomStatus)
            roomService.changeFreeStatus(roomID, true);
    }

    public void checkAllRooms() { roomService.getAllRooms(); }

    public void checkAllServices() { service.getAllServices(); }

    public void checkAllClients() { clientService.getClients(); }

    public void changeCostRoom(Integer id, double cost) { roomService.changeCostRoom(id, cost); }

    public void changeFixStatus(Integer id, boolean fixStatus) { roomService.changeFixStatus(id, fixStatus); }

    public void changeFreeStatus(Integer id, boolean status) { roomService.changeFreeStatus(id, status); }

    public void changeCostService(String name, double cost) { service.changeCostService(name, cost); }

}
