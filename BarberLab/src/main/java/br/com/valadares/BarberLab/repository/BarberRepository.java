package br.com.valadares.BarberLab.repository;

import br.com.valadares.BarberLab.model.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepository extends JpaRepository<Barber, Long> {
}
