package com.senla.dao;

import com.senla.entity.Client;
import com.senla.entity.Room;

public class FileClientDao implements IClientDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public FileClientDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

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
