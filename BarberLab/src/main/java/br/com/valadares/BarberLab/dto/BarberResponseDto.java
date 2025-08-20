package br.com.valadares.BarberLab.dto;

import br.com.valadares.BarberLab.model.Barber;

import java.time.LocalDateTime;

public record BarberResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        LocalDateTime createdAt) {

    public BarberResponseDto(Barber barber) {
        this(barber.getId(), barber.getFirstName(),
                barber.getLastName(), barber.getEmail(),
                barber.getPhone(), barber.getCreatedAt());
    }

}
