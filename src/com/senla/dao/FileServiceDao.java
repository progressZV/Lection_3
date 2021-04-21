package com.senla.dao;

import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class FileServiceDao implements IServiceDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public FileServiceDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    @Override
    public void saveService(Service service) {
        fileStreamWriter.write(service.toString(), true);
    }

    @Override
    public void deleteService(String name) {
        fileStreamWriter.write(name, false);
    }

    @Override
    public List<Service> getServices() {
        String fileData = fileStreamReader.readFile();
        List<Service> services = new ArrayList<>();
        if(!fileData.isEmpty()) {
            String[] ary = fileData.split("\n");

            for (int i = 0; i < ary.length; i++) { // check
                String[] words = ary[i].split("\t");
                for(int j = 0; j< words.length; j++)
                    words[j] = words[j].trim();
                services.add(new Service(words[0], Double.parseDouble(words[1])));
            }
        }
        return services;
    }

}
