package br.com.valadares.BarberLab.dto;

public record ClientUpdateDto(Long id,
                              String firstName,
                              String phone,
                              String email) {
}
