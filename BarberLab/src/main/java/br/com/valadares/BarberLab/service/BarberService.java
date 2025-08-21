package br.com.valadares.BarberLab.service;

import br.com.valadares.BarberLab.dto.BarberDto;
import br.com.valadares.BarberLab.dto.BarberResponseDto;
import br.com.valadares.BarberLab.dto.BarberUpdateDto;
import br.com.valadares.BarberLab.model.Barber;
import br.com.valadares.BarberLab.repository.BarberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BarberService {

    private final BarberRepository repository;
    public BarberService(BarberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public BarberResponseDto create(BarberDto dto) {
        var barber = new Barber(dto);
        repository.save(barber);

        return new BarberResponseDto(barber);
    }

    public Page<BarberResponseDto> findAll(@PageableDefault(size = 10, sort = "firstName",
                                            direction = Sort.Direction.ASC)Pageable pageable) {

        return repository.findAll(pageable).map(BarberResponseDto::new);
    }

    @Transactional
    public BarberResponseDto update(Long id, BarberUpdateDto updateDto) {
        var barber = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        barber.update(updateDto);
        return new BarberResponseDto(barber);
    }

    @Transactional
    public ResponseEntity<Void> delete(Long id) {
        var barber = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        repository.delete(barber);
        return ResponseEntity.noContent().build();
    }
}
