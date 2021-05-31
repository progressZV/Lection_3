package com.senla.controller;

import com.senla.entity.Service;
import com.senla.service.ServiceOfServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("service")
public class ServiceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ServiceOfServices serviceOfServices;

    public ServiceController(ServiceOfServices serviceOfServices) {
        this.serviceOfServices = serviceOfServices;
    }

    @GetMapping
    public List<Service> serviceList(){
        logger.info("List of the services.");
        return serviceOfServices.getAllServices(); }

    @GetMapping("{id}")
    public ResponseEntity getService(@PathVariable("id") String name){
        logger.info("Get service " + name);
            return ResponseEntity.ok(serviceOfServices.getService(name));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid Service service) {
        logger.info("Create service ("+ service +")");
            serviceOfServices.addService(service);
            return ResponseEntity.ok("Service is added.");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable("id") String name, @RequestBody @Valid Service service){
        logger.info("Update service "+ name);
            serviceOfServices.updateService(name,service);
            return ResponseEntity.ok("Service is updated.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> remove(@PathVariable("id") String name){
        logger.info("Remove service "+ name);
            serviceOfServices.deleteService(name);
            return ResponseEntity.ok("Service is removed.");
    }
}
