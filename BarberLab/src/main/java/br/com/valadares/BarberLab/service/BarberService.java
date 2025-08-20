package br.com.valadares.BarberLab.service;

import br.com.valadares.BarberLab.repository.BarberRepository;
import org.springframework.stereotype.Service;

@Service
public class BarberService {

    private final BarberRepository repository;
    public BarberService(BarberRepository repository) {
        this.repository = repository;
    }

}
