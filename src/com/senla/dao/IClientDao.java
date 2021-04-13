package com.senla.dao;

import com.senla.entity.Client;
import com.senla.entity.Room;

public interface IClientDao {
    void saveClient(Room room, Client client);
    void removeClient(String name);
    void getClients(String str);
}
