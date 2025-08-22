package br.com.valadares.BarberLab.repository;

import br.com.valadares.BarberLab.model.OfferedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferedServiceRepository extends JpaRepository<OfferedService, Long> {
}
