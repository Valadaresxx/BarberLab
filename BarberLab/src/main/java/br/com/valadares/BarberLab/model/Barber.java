package br.com.valadares.BarberLab.model;

import br.com.valadares.BarberLab.dto.BarberDto;
import br.com.valadares.BarberLab.dto.BarberUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "barbers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Barber {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @ManyToMany
    private List<Service> services;

    @PrePersist
    public void prePersist() {
        if(this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Barber(BarberDto dto) {
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.email = dto.email();
        this.phone = dto.phone();
    }

    public void update(BarberUpdateDto updateDto) {
        if(updateDto.firstName() != null && !updateDto.firstName().isBlank()) {
            this.firstName = updateDto.firstName();
        }
        if (updateDto.phone() != null) {
            this.phone = updateDto.phone();
        }
        if (updateDto.email() != null && !updateDto.email().isBlank()) {
            this.email = updateDto.email();
        }
    }
}
