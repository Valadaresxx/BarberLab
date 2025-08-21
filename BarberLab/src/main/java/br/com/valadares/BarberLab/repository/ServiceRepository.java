package br.com.valadares.BarberLab.repository;

import br.com.valadares.BarberLab.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
