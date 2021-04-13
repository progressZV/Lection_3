package com.senla.dao;

import com.senla.entity.Service;

public interface IServiceDao {
    void saveService(Service service);
    void deleteService(String name);
    void getService(String str);
}
