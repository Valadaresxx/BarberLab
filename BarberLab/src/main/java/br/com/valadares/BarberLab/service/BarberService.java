package br.com.valadares.BarberLab.service;

import br.com.valadares.BarberLab.dto.BarberDto;
import br.com.valadares.BarberLab.dto.BarberResponseDto;
import br.com.valadares.BarberLab.model.Barber;
import br.com.valadares.BarberLab.repository.BarberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Page<BarberResponseDto> findAll(@PageableDefault(size = 10, sort = "firstName", direction = Sort.Direction.ASC)Pageable pageable) {
        return repository.findAll(pageable).map(BarberResponseDto::new);
    }
}
