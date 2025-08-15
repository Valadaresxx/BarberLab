package br.com.valadares.BarberLab.dto;

import java.time.LocalDateTime;

public record ClientDto(
        String firstName,
        String lastName,
        String cpf,
        String email,
        String phone,
        LocalDateTime createdAt) {
}
