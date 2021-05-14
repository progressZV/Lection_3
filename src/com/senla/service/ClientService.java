package com.senla.service;

import com.senla.dao.*;
import com.senla.entity.Client;
import com.senla.entity.Room;

import java.util.List;

public class ClientService {
      private IClientDao clientService = new FileClientDao(new FileStreamWriter("Clients.txt"), new FileStreamReader("Clients.txt"), new Parser());
      private IRoomDao roomDao= new FileRoomDao(new FileStreamWriter("Rooms.txt"), new FileStreamReader("Rooms.txt"), new Parser());
      private IClientDao iClientService = new JDBCClientDao();
      private IRoomDao iRoomDao = new JDBCRoomDao();

    public boolean addClient(Integer roomId, Client client) {
        var room = iRoomDao.getRooms().stream().filter(r -> r.getNumber() == roomId).findFirst().orElse(null);
        if (room == null) {
            System.out.println("Can't find the room.");
            return false;
        }

        if (room.getFreeStatus() && !room.getFixStatus()) {
            iClientService.saveClient(client);
            iRoomDao.changeFreeStatus(roomId, false);
            System.out.println("Клиент " + client.getName() + " успешно заслелён в комнату №" + room.getNumber());
            return true;
        }
            System.out.println("Номер занят или не существует." + "\n");
        return false;
    }

    public boolean removeClient(String name, Integer roomID) {

        var room = iRoomDao.getRooms().stream().filter(r -> r.getNumber() == roomID).findFirst().orElse(null);
        if (room == null) {
            System.out.println("Can't find the room.");
            return false;
        }

        Client client = iClientService.getClients().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);

        if(client == null){
            System.out.println("Can't find a client.");
            return false;
        }
        if(client.getAppsNumber() != room.getNumber()){
            System.out.println("Клиент не поселён в данном номере.");
            return false;
        }

        iClientService.removeClient(name, roomID);
        iRoomDao.changeFreeStatus(client.getAppsNumber(), true);
        System.out.println("Client " + client.getName() + " was removed from room №" + client.getAppsNumber());
        return true;
    }

    public List<Client> getClients(){
        List<Client> clients = iClientService.getClients();
        for(Client client : clients){
            System.out.println(client.convertToString());
        }
        return clients;
    }
}


