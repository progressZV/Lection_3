package com.senla.dao;

import com.senla.entity.Service;

import java.util.List;

public interface IServiceDao {
    void saveService(Service service);
    void deleteService(String name);
    List<Service> getServices();
    void changePrice(String name, double price);
}
