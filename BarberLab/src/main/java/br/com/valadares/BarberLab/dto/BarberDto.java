package br.com.valadares.BarberLab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record BarberDto(
        @NotBlank(message = "O primeiro nome não pode ficar vazio.")
        String firstName,
        String lastName,

        @NotBlank(message = "O email não pode estar em branco.")
        @Email(message = "E-mail formato inválido.")
        String email,
        String phone

) {
}
