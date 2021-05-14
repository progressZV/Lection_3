package com.senla.dao;

import com.senla.entity.Client;

import java.util.List;

public class FileClientDao implements IClientDao{

    private final FileStreamWriter fileStreamWriter;
    private final FileStreamReader fileStreamReader;
    private final Parser parser;

    public FileClientDao(FileStreamWriter fileStreamWriter, FileStreamReader fileStreamReader, Parser parser){
        this.fileStreamWriter = fileStreamWriter;
        this.fileStreamReader = fileStreamReader;
        this.parser = parser;
    }

    @Override
    public void saveClient(Client client) {
        fileStreamWriter.write(client.convertToString(), true);
    }

    @Override
    public void removeClient(String name, Integer id) {
        fileStreamWriter.write(name,false);
    }

    @Override
    public List<Client> getClients() {
        String fileData = fileStreamReader.readFile();
        return parser.convertToClient(fileData);
    }
}
