package com.senla.model;

import com.senla.entity.Client;

public class ClientDTO {
    private String name = null;
    private Integer appsNumber;

    public static ClientDTO toModel(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setAppsNumber(client.getAppsNumber());
        clientDTO.setName(client.getName());
        return clientDTO;
    }

    public ClientDTO(){}

    public Integer getAppsNumber() { return appsNumber; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppsNumber(Integer appsNumber) {
        this.appsNumber = appsNumber;
    }
}
