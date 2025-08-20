package br.com.valadares.BarberLab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClientDto(
        @NotBlank(message = "O primeiro nome não pode ficar vazio.")
        String firstName,
        String lastName,

        @Size(min = 11, max = 11, message = "Cpf deve ter 11 dígitos.")
        @Pattern(regexp = "\\d+", message = "Cpf deve conter apenas números.")
        String cpf,

        @NotBlank(message = "O email não pode estar em branco.")
        @Email(message = "E-mail formato inválido.")
        String email,
        String phone) {
}
