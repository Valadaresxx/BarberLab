package br.com.valadares.BarberLab.service;


import br.com.valadares.BarberLab.dto.OfferedServiceDto;
import br.com.valadares.BarberLab.dto.OfferedServiceResponseDto;
import br.com.valadares.BarberLab.model.OfferedService;
import br.com.valadares.BarberLab.repository.OfferedServiceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OfferedServiceService {

    private final OfferedServiceRepository repository;
    public OfferedServiceService(OfferedServiceRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OfferedServiceResponseDto create(@RequestBody OfferedServiceDto dto) {
        var service = new OfferedService(dto);
        repository.save(service);
        return new OfferedServiceResponseDto(service);
    }
}
