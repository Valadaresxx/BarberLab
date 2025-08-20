package br.com.valadares.BarberLab.controller;

import br.com.valadares.BarberLab.dto.ClientDto;
import br.com.valadares.BarberLab.dto.ClientResponseDto;
import br.com.valadares.BarberLab.dto.ClientUpdateDto;
import br.com.valadares.BarberLab.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> create(@RequestBody ClientDto dto) {
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

    @GetMapping
    public ResponseEntity<Page<ClientResponseDto>> list(Pageable page) {
        var json = service.findAll(page);
        return ResponseEntity.ok(json);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> update(@PathVariable Long id, @RequestBody ClientUpdateDto dto) {
        var json = service.update(id, dto);
        return ResponseEntity.ok(json);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}













