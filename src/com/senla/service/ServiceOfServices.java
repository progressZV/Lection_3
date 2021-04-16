package com.senla.service;

import com.senla.dao.FileServiceDao;
import com.senla.dao.FileStreamReader;
import com.senla.dao.FileStreamWriter;
import com.senla.dao.IServiceDao;
import com.senla.entity.Room;
import com.senla.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceOfServices {

    private IServiceDao serviceDao = new FileServiceDao(new FileStreamWriter("Services.txt"), new FileStreamReader("Services.txt"));
    ;
    //   private final List<Service> services = new ArrayList();


    public void addService(Service service) {
        var service1 = serviceDao.getServices().stream().filter(s -> s.getName() == service.getName()).findFirst();
        if (service1.isPresent()) {
            System.out.println("Service with this name already exists.");
            return;
        }
        serviceDao.saveService(service);
        System.out.println("Service " + service.getName() + " was added successfully.");
    }

    public void deleteService(String name) {
        List<Service> services = serviceDao.getServices();
        Service service = serviceDao.getServices().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (service == null) {
            System.out.println("Can't find the service.");
            return;
        }
        services.remove(service);
        StringBuilder sb = new StringBuilder();
        for (Service service1 : services) {
            sb.append(service1.toString());
        }
        serviceDao.deleteService(sb.toString());
        System.out.println("Service " + service.getName() + " was removed successfully.");
    }

    public List<Service> getAllServices() {
        return serviceDao.getServices();
    }
}
