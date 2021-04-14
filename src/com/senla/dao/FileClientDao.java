package com.senla.dao;

import com.senla.entity.Client;
import com.senla.entity.Room;

public class FileClientDao implements IClientDao{

    private final FileStreamWriter fileStreamWriter = new FileStreamWriter("Hotel.txt");
    private final FileStreamReader fileStreamReader = new FileStreamReader();


    @Override
    public void saveClient(Room room, Client client) {
        fileStreamWriter.write("Запись клиента:" + "\n");
        fileStreamWriter.write("Клиент " + client.getName() + " успешно заселён в номер " + room.getNumber() + "\n" + "\n");
    }

    @Override
    public void removeClient(String name) {
        fileStreamWriter.write("Удаление клиента:" + "\n");
        fileStreamWriter.write("Клиент " + name + "выселен из номера" + "\n" + "\n");
    }

    @Override
    public final void getClients(String str) {
        fileStreamWriter.write("Список клиентов:" + "\n");
        fileStreamWriter.write(str);
    }
}
