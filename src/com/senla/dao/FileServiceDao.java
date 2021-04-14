package com.senla.dao;

import com.senla.entity.Service;

public class FileServiceDao implements IServiceDao{

    private final FileStreamWriter fileStreamWriter = new FileStreamWriter("Hotel.txt");
    private final FileStreamReader fileStreamReader = new FileStreamReader();

    @Override
    public void saveService(Service service) {
        fileStreamWriter.write("Запись сервиса:" + "\n");
        fileStreamWriter.write(service.toString() + "\n");
    }

    @Override
    public void deleteService(String name) {
        fileStreamWriter.write("Удаление сервиса:" + "\n");
        fileStreamWriter.write("Сервис " + name + " удалён." + "\n" + "\n");
    }

    @Override
    public void getService(String str) {
        fileStreamWriter.write("Список сервисов:" + "\n");
        fileStreamWriter.write(str);
    }

}
