package br.com.valadares.BarberLab.dto;

import br.com.valadares.BarberLab.model.Client;

import java.time.LocalDateTime;

public record ClientResponseDto(
        Long id,
        String firstName,
        String lastName,
        String cpf,
        String email,
        String phone,
        LocalDateTime createdAt) {

    public ClientResponseDto(Client client) {
        this(client.getId(), client.getFirstName(), client.getLastName(),
                client.getCpf(), client.getEmail(), client.getPhone(), client.getCreatedAt());
    }
}
