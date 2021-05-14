package com.senla.service;

import com.senla.dao.*;
import com.senla.entity.Service;

import java.util.List;

public class ServiceOfServices {

//    private IServiceDao serviceDao = new FileServiceDao(new FileStreamWriter("Services.txt"), new FileStreamReader("Services.txt"), new Parser());
    private IServiceDao iServiceDao = new JDBCServiceDao();


    public void addService(Service service) {
        var service1 = iServiceDao.getServices().stream().filter(s -> s.getName().equals(service.getName())).findFirst();
        if (service1.isPresent()) {
            System.out.println("Service with this name already exists.");
            return;
        }
       iServiceDao.saveService(service);
        System.out.println("Service " + service.getName() + " was added successfully.");
    }

    public void deleteService(String name) {
        Service service = iServiceDao.getServices().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (service == null) {
            System.out.println("Can't find the service.");
            return;
        }

        iServiceDao.deleteService(name);
        System.out.println("Service " + service.getName() + " was removed successfully.");
    }

    public void changeCostService(String name, double cost) {
        Service service1 = iServiceDao.getServices().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (service1 == null) {
            System.out.println("Can't find the service.");
            return;
        }
        if (service1.getCost() == cost) {
            System.out.println("We have already this cost.");
            return;
        }

        iServiceDao.changePrice(name, cost);
        System.out.println("Cost changed for Service №" + name);
    }

    public List<Service> getAllServices() {
        List<Service> services = iServiceDao.getServices();
        for(Service service : services){
            System.out.println(service.convertToString());
        }
        return services;
    }
}
