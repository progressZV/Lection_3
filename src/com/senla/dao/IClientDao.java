package com.senla.dao;

import com.senla.entity.Client;

import java.util.List;

public interface IClientDao {
    void saveClient(Client client);
    void removeClient(String name, Integer id);
    List<Client> getClients();
}
