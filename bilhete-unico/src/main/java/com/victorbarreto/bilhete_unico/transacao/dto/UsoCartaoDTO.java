package com.victorbarreto.bilhete_unico.transacao.dto;

import com.victorbarreto.bilhete_unico.transacao.entity.TipoTransacao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UsoCartaoDTO(
        @NotNull(message = "O numero do cartão não pode ser nulo.") @Positive(message = "O numero do cartão deve ser um número positivo.") Integer numero ,
        TipoTransacao tipoTransacao) {
}
