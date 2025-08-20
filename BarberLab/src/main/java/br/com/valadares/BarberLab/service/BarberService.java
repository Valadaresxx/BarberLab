package br.com.valadares.BarberLab.service;

import br.com.valadares.BarberLab.dto.BarberDto;
import br.com.valadares.BarberLab.dto.BarberResponseDto;
import br.com.valadares.BarberLab.model.Barber;
import br.com.valadares.BarberLab.repository.BarberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BarberService {

    private final BarberRepository repository;
    public BarberService(BarberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ResponseEntity create(BarberDto dto) {
        var barber = new Barber(dto);
        repository.save(barber);

        return ResponseEntity.ok(new BarberResponseDto(barber));
    }
}
