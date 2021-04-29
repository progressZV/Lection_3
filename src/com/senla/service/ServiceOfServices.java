package com.senla.service;

import com.senla.dao.*;
import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceOfServices {

    private IServiceDao serviceDao = new FileServiceDao(new FileStreamWriter("Services.txt"), new FileStreamReader("Services.txt"), new Parser());
    //   private final List<Service> services = new ArrayList();


    public void addService(Service service) {
        var service1 = serviceDao.getServices().stream().filter(s -> s.getName().equals(service.getName())).findFirst();
        if (service1.isPresent()) {
            System.out.println("Service with this name already exists.");
            return;
        }
        serviceDao.saveService(service);
        System.out.println("Service " + service.getName() + " was added successfully.");
    }

    public void deleteService(String name) {
        List<Service> services = serviceDao.getServices();
        Service service = services.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (service == null) {
            System.out.println("Can't find the service.");
            return;
        }
        services.remove(service);
        StringBuilder sb = new StringBuilder();
        for (Service service1 : services) {
            sb.append(service1.convertToString());
        }
        serviceDao.deleteService(sb.toString());
        System.out.println("Service " + service.getName() + " was removed successfully.");
    }

    public void changeCostService(String name, double cost) {
        List<Service> services = serviceDao.getServices();
        Service service1 = services.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (service1 == null) {
            System.out.println("Can't find the service.");
            return;
        }
        if (service1.getCost() == cost) {
            System.out.println("We have already this cost.");
            return;
        }
        service1.setCost(cost);
        StringBuilder sb = new StringBuilder();
        for (Service service2 : services) {
            sb.append(service2.convertToString());
        }
        serviceDao.deleteService(sb.toString());
        System.out.println("Cost changed for Room №" + name);
    }

    public List<Service> getAllServices() {
        List<Service> services = serviceDao.getServices();
        for(Service service : services){
            System.out.println(service.convertToString());
        }
        return services;
    }
}
