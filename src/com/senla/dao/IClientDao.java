package com.senla.dao;

import com.senla.entity.Client;
import com.senla.entity.Room;

import java.util.List;

public interface IClientDao {
    void saveClient(Client client);
    void removeClient(String name);
    List<Client> getClients();
}
