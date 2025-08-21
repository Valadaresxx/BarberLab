package br.com.valadares.BarberLab.controller;

import br.com.valadares.BarberLab.dto.BarberDto;
import br.com.valadares.BarberLab.dto.BarberResponseDto;
import br.com.valadares.BarberLab.dto.BarberUpdateDto;
import br.com.valadares.BarberLab.service.BarberService;
import jakarta.validation.Valid;
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
    public ResponseEntity<BarberResponseDto> create(@Valid @RequestBody BarberDto dto) {
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

    @PutMapping("{id}")
    public ResponseEntity<BarberResponseDto> update(@Valid @PathVariable Long id, @RequestBody BarberUpdateDto updateDto) {
        var json = service.update(id, updateDto);
        return ResponseEntity.ok(json);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
