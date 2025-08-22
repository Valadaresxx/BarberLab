package br.com.valadares.BarberLab.dto;

import br.com.valadares.BarberLab.model.OfferedService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OfferedServiceResponseDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer durationMinutes,
        LocalDateTime createdAt) {

    public OfferedServiceResponseDto(OfferedService service) {
        this(service.getId(), service.getName(), service.getDescription(),
                service.getPrice(), service.getDurationMinutes(), service.getCreatedAt());
    }
}
