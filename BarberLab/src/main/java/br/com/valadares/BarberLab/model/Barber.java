package br.com.valadares.BarberLab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String name;
    @OneToMany
    private List<Service> services;
}
