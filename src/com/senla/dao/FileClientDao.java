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
        fileStreamWriter.write(client.toString());
    }

    @Override
    public void removeClient(String name) {
        List<Client> clients = getClients();
        Client client = clients.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if(client == null){
            System.out.println("Can't find the service.");
            return;
        }
        clients.remove(client);
        StringBuilder sb = new StringBuilder();
        for(Client client1 : clients){
            sb.append(client1.toString());
        }
        fileStreamWriter.write(sb.toString());
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
