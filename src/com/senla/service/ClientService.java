package com.senla.service;

import com.senla.dao.*;
import com.senla.entity.Client;
import com.senla.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
      private IClientDao clientService = new FileClientDao(new FileStreamWriter("Clients.txt"), new FileStreamReader("Clients.txt"));
    //  private final List<Client> clients = new ArrayList<>();


    public void addClient(Room room, Client client) {

        if (room.getFreeStatus() && !room.getFixStatus()) {
            room.setFreeStatus(false);
            clientService.saveClient(client);
            System.out.println("Клиент " + client.getName() + " успешно заслелён в комнату №" + room.getNumber());
            return;
        }
            System.out.println("Номер занят или не существует." + "\n");
    }

    public void removeClient(String name, Room room) {
        List<Client> clients = clientService.getClients();
        Client client = clientService.getClients().stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
        if(client == null){
            System.out.println("Can't find a client.");
            return;
        }
        if(client.getAppsNumber() != room.getNumber()){
            System.out.println("Клиент не поселён в данном номере.");
            return;
        }
        clients.remove(client);
        StringBuilder sb = new StringBuilder();
        for (Client client1 : clients) {
            sb.append(client1.toString());
        }
        clientService.removeClient(sb.toString());
        System.out.println("Client " + client.getName() + " was removed from room №" + client.getAppsNumber());
    }
    public List<Client> getClients(){
        return  clientService.getClients();
    }
}


