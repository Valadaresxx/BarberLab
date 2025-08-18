package br.com.valadares.BarberLab.service;

import br.com.valadares.BarberLab.dto.ClientDto;
import br.com.valadares.BarberLab.dto.ClientResponseDto;
import br.com.valadares.BarberLab.dto.ClientUpdateDto;
import br.com.valadares.BarberLab.model.Client;
import br.com.valadares.BarberLab.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository repository;
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientResponseDto create(ClientDto dto) {
        var client = new Client(dto);
        repository.save(client);

        return new ClientResponseDto(client);
    }

    public Page<ClientResponseDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(ClientResponseDto::new);
    }

    public ClientResponseDto update(Long id, ClientUpdateDto updateDto) {
        var client = repository.getReferenceById(id);
        client.update(updateDto);

        return new ClientResponseDto(client);
    }
}
