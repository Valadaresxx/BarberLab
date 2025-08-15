package br.com.valadares.BarberLab.repository;


import br.com.valadares.BarberLab.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
