package com.victorbarreto.bilhete_unico.cartao.dto;

import com.victorbarreto.bilhete_unico.cartao.entity.TipoCartao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CartaoCreateDTO(
        @NotNull(message = "O ID do usuário não pode ser nulo.") @Positive(message = "O ID do usuário deve ser um número positivo.") Long idUsuario,
        @NotNull(message = "O tipo do cartão não pode ser nulo.") TipoCartao tipo) {
}
