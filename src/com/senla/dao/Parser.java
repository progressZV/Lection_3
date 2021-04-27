package com.senla.dao;

import com.senla.entity.Client;
import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Room> convertToRoom(String fileData){
        List<Room> rooms = new ArrayList<>();
        if(!fileData.isEmpty()) {
            String[] ary = fileData.split("\n");
            for (int i = 0; i < ary.length; i++) { //check
                String[] words = ary[i].split("\t");
                for(int j = 0; j< words.length; j++)
                    words[j] = words[j].trim();
                rooms.add(new Room(Integer.parseInt(words[0]), Double.parseDouble(words[1]), Integer.parseInt(words[2]),
                        Integer.parseInt(words[3]), Boolean.parseBoolean(words[4]), Boolean.parseBoolean(words[5])));
            }
        }
        return rooms;
    }
    public List<Service> convertToService(String fileData){
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
    public List<Client> convertToClient(String fileData){
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
