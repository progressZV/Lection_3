package com.senla.dao;

import com.senla.entity.Client;
import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class FileClientDao implements IClientDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;

    public FileClientDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
    }

    @Override
    public void saveClient(Client client) {
        fileStreamWriter.write(client.toString(), true);
    }

    @Override
    public void removeClient(String name) {
        fileStreamWriter.write(name,false);
    }

    @Override
    public List<Client> getClients() {
        String fileData = fileStreamReader.readFile();
        List<Client> clients = new ArrayList<>();
        if(!fileData.isEmpty()) {
            String[] ary = fileData.split("\n");
            for (int i = 0; i < ary.length; i++) { //check
                String[] words = ary[i].split("\t");
                for(int j = 0; j< words.length; j++)
                    words[j] = words[j].trim();
                clients.add(new Client(words[0], Integer.parseInt(words[1])));
            }
        }
        return clients;
    }
}
