package com.senla.service;

import com.senla.dao.FileClientDao;
import com.senla.dao.FileStreamReader;
import com.senla.dao.FileStreamWriter;
import com.senla.dao.IClientDao;
import com.senla.entity.Client;
import com.senla.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
      private IClientDao clientService = new FileClientDao(new FileStreamWriter("Clients.txt"), new FileStreamReader("Clients.txt"));
      private final List<Client> clients = new ArrayList<>();


    public void saveClient(Room room, Client client) {

        if (room.getFreeStatus() && !room.getFixStatus()) {
            room.setFreeStatus(false);
            clients.add(client);
            clientService.saveClient(room, client);
            return;
        }
            System.out.println("Номер занят или не существует." + "\n");
    }
    public void removeClient(String name, Room room) {
        if (clients.size() > 0) {
            for (Client client : clients) {
                if (client.getName() == name) {
                    clients.remove(client);
                    room.setFreeStatus(true);
                    clientService.removeClient(name + " ");
                    return;
                }
            }
        }
            System.out.println("Такого клиента нету, либо он не прописан в данном номере." + "\n");
    }
    public void getClients(){
        StringBuilder stringBuilder = new StringBuilder();
       for(Client client : clients){
           stringBuilder.append(client.getName() + "\n");
       }
       clientService.getClients(stringBuilder.toString() + "\n");
    }
}


