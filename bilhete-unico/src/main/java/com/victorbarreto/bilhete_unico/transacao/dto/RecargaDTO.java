package com.victorbarreto.bilhete_unico.transacao.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RecargaDTO(
        @NotNull(message = "O numero do cartão não pode ser nulo.") @Positive(message = "O numero do cartão deve ser um número positivo.") Integer numero,
        @NotNull(message = "O valor da recarga não pode ser nulo.") @Positive(message = "O valor da recarga deve ser um número positivo.") BigDecimal valor) {
}
