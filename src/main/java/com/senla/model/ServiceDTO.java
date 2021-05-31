package com.senla.model;

import com.senla.entity.Service;


public class ServiceDTO {

    private String name = null;
    private double cost = 0;

    public static ServiceDTO toModel(Service service){
       ServiceDTO serviceDTO = new ServiceDTO();
       serviceDTO.setCost(service.getCost());
       serviceDTO.setName(service.getName());
       return serviceDTO;
    }


    public ServiceDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
