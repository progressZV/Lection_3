package com.senla.service;

import com.senla.dao.FileServiceDao;
import com.senla.dao.IServiceDao;
import com.senla.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceOfServices {

    private IServiceDao serviceDao= new FileServiceDao();
    private final List<Service> services = new ArrayList();

    public void addService(Service service) {
            for (Service service1 : services) {
                if (service.getName() == service1.getName()) {
                    System.out.println("Данная услуга уже существует" + "\n");
                    return;
                }
            }
            services.add(service);
            serviceDao.saveService(service);
    }
    public void deleteService(String name) {
        if (services.size() > 0) {
            for (Service service : services) {
                if (service.getName() == name) {
                    services.remove(service);
                    serviceDao.deleteService(name);
                    return;
                }
            }
        }
            System.out.println("Такого сервиса не существует." + "\n");
    }

    public void getAllServices() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Service service : services){
            stringBuilder.append(service.toString()).append("\n");
        }
        serviceDao.getService(stringBuilder.toString());
    }
}
