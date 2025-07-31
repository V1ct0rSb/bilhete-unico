package com.victorbarreto.bilhete_unico.usuario.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UsuarioCreateDTO(@NotBlank(message = "Nome Obrigatório") String nome,
                               @NotBlank(message = "CPF é obrigatório") @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos") String cpf,
                               @NotNull(message = "O campo data não pode ser nulo") LocalDate dataNasc) {
}
