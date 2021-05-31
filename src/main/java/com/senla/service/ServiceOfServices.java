package com.senla.service;

import com.senla.dao.*;
import com.senla.entity.Service;
import com.senla.exception.GlobalException;
import com.senla.model.ServiceDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceOfServices {

    private final ServiceRepository serviceRepository;

    public ServiceOfServices(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service addService(Service service) {
        var service1 = getAllServices().stream().filter(s -> s.getName().equals(service.getName()) || s.getId().equals(service.getId())).findFirst();
        if (service1.isPresent()) {
            throw new GlobalException("Service is already exist.");
        }
       return serviceRepository.save(service);
    }

    public ServiceDTO getService(String name){
        Service service = serviceRepository.getByName(name);
        if(service == null){
            throw new GlobalException("Service is not founded");
        }
        return ServiceDTO.toModel(service);
    }

    public void deleteService(String name) {
        Service service = getAllServices().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
        if (service == null) {
            throw new GlobalException("Service is not founded.");
        }
        serviceRepository.delete(service);
    }

    public Service updateService(String serviceFromDbName, Service service){
        var serviceFromDb = serviceRepository.getByName(serviceFromDbName);
        if (serviceFromDb == null) {
            throw new GlobalException("Service in not founded.");
        }
        BeanUtils.copyProperties(service, serviceFromDb, "id", "name");
        return serviceRepository.save(serviceFromDb);
    }

    public List<Service> getAllServices() { return serviceRepository.findAll(); }
}
