package br.com.valadares.BarberLab.controller;

import br.com.valadares.BarberLab.dto.ClientDto;
import br.com.valadares.BarberLab.model.Client;
import br.com.valadares.BarberLab.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    private ResponseEntity<Client> save(@RequestBody ClientDto dto) {
        var client = new Client(dto);
        repository.save(client);
        return ResponseEntity.ok().body(client);
    }
}













