package br.com.valadares.BarberLab.controller;

import br.com.valadares.BarberLab.dto.BarberDto;
import br.com.valadares.BarberLab.dto.BarberResponseDto;
import br.com.valadares.BarberLab.service.BarberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/barbers")
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

    @GetMapping
    public ResponseEntity<Page<BarberResponseDto>> list(Pageable pageable) {
        var json = service.findAll(pageable);
        return ResponseEntity.ok(json);
    }
}
