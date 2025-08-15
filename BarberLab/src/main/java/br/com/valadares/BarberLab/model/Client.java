package br.com.valadares.BarberLab.model;

import br.com.valadares.BarberLab.dto.ClientDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String cpf;

    @Column(nullable = false)
    private String email;

    private String phone;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Client(ClientDto dto) {
        this.firstName = dto.firstName();
        this.lastName = dto.lastName();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.phone = dto.phone();
    }

    @PrePersist
     public void prePersist() {
        if(this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
     }

}
