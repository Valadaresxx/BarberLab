package br.com.valadares.BarberLab.dto;

public record ClientDto(
        String firstName,
        String lastName,
        String cpf,
        String email,
        String phone) {
}
