package com.senla.controller;

import com.senla.entity.Client;
import com.senla.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        logger.info("List of the clients.");
        return clientService.getClients(); }

    @GetMapping("{id}")
    public ResponseEntity getClient(@PathVariable("id") Integer clientRoom){
        logger.info("Get client from" + clientRoom);
            return ResponseEntity.ok(clientService.getClient(clientRoom));
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody @Valid Client client){
        logger.info("Add client ("+ client +")");
            clientService.addClient(client);
            return ResponseEntity.ok("Client is added.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> remove(@PathVariable("id") Integer roomNumber){
        logger.info("Remove client from room № " + roomNumber);
            clientService.deleteClient(roomNumber);
            return ResponseEntity.ok("Client is removed.");
    }

}
