package com.senla.dao;

import com.senla.entity.Service;

public class FileServiceDao implements IServiceDao{

    private final FileStreamWriter fileStreamWriter = new FileStreamWriter("Hotel.txt");
    private final FileStreamReader fileStreamReader = new FileStreamReader();

    @Override
    public void saveService(Service service) {
        fileStreamWriter.write(service.toString() + "\n");
    }

    @Override
    public void deleteService(String name) {
        fileStreamWriter.write("Сервис " + name + " удалён." + "\n");
    }

    @Override
    public void getService(String str) {
        fileStreamWriter.write(str + "\n");
    }

}
