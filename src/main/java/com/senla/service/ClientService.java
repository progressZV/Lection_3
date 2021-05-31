package com.senla.service;

import com.senla.dao.ClientRepository;
import com.senla.dao.RoomRepository;
import com.senla.entity.Client;
import com.senla.exception.GlobalException;
import com.senla.model.ClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final RoomRepository roomRepository;

    public ClientService(ClientRepository clientRepository, RoomRepository roomRepository) {
        this.clientRepository = clientRepository;
        this.roomRepository = roomRepository;
    }

    public Client addClient(Client client) {
        var room = roomRepository.getByNumber(client.getAppsNumber());
        if (room == null) {
            throw new GlobalException("Room is not founded.");
        }
        var client1 = getClients().stream().filter(c -> c.getAppsNumber().equals(client.getAppsNumber()) || c.getId().equals(client.getId())).findFirst();
        if (client1.isPresent()) {
            throw new GlobalException("Client is already exist in this Room.");
        }
        roomRepository.updateFreeStatus(false, client.getAppsNumber());
        return clientRepository.save(client);
    }

    public ClientDTO getClient(Integer roomNumber){
        var client = clientRepository.getByNumber(roomNumber);
        if(client == null){
            throw new GlobalException("Client is not founded.");
        }
        return ClientDTO.toModel(client);
    }

    public void deleteClient(Integer roomNumber) {
        var client = clientRepository.getByNumber(roomNumber);
        if(client == null){
            throw new GlobalException("Client is not founded.");
        }
        var room = roomRepository.getByNumber(roomNumber);
        if (room == null) {
            throw new GlobalException("Room is not founded for this client.");
        }
        roomRepository.updateFreeStatus(true, client.getAppsNumber());
        clientRepository.delete(client);
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
}



