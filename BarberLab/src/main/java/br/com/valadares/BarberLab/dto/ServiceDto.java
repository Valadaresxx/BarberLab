package br.com.valadares.BarberLab.dto;

import java.math.BigDecimal;

public record ServiceDto(
        String name,
        String description,
        BigDecimal price,
        Integer durationMinutes) {
}
