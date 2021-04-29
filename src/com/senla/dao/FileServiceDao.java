package com.senla.dao;

import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class FileServiceDao implements IServiceDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;
    private final Parser parser;

    public FileServiceDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader, Parser parser){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
        this.parser = parser;
    }

    @Override
    public void saveService(Service service) {
        fileStreamWriter.write(service.convertToString(), true);
    }

    @Override
    public void deleteService(String name) {
        fileStreamWriter.write(name, false);
    }

    @Override
    public List<Service> getServices() {
        String fileData = fileStreamReader.readFile();
        return  parser.convertToService(fileData);
    }

}
