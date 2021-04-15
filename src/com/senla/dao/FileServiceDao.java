package com.senla.dao;

import com.senla.entity.Service;

public class FileServiceDao implements IServiceDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public FileServiceDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

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
