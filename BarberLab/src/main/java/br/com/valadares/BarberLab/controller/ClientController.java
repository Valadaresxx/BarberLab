package br.com.valadares.BarberLab.controller;

import br.com.valadares.BarberLab.dto.ClientDto;
import br.com.valadares.BarberLab.dto.ClientResponseDto;
import br.com.valadares.BarberLab.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping
    private ResponseEntity<ClientResponseDto> create(@RequestBody ClientDto dto) {
        var client = service.create(dto);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client.id())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(client);
    }
}













