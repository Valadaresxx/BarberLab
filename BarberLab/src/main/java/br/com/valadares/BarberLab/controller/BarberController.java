package br.com.valadares.BarberLab.controller;

import br.com.valadares.BarberLab.dto.BarberDto;
import br.com.valadares.BarberLab.dto.BarberResponseDto;
import br.com.valadares.BarberLab.model.Barber;
import br.com.valadares.BarberLab.service.BarberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/barber")
public class BarberController {

    private final BarberService service;
    public BarberController(BarberService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BarberResponseDto> create(@RequestBody BarberDto dto) {
        var barber = service.create(dto);

        var URI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(barber.id())
                .toUri();

        return ResponseEntity.created(URI).body(barber);
    }
}
