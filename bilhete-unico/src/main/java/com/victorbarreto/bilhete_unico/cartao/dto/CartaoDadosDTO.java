package com.victorbarreto.bilhete_unico.cartao.dto;

import java.math.BigDecimal;

import com.victorbarreto.bilhete_unico.cartao.entity.TipoCartao;

public record CartaoDadosDTO(BigDecimal saldo, Boolean status, TipoCartao tipo, String nome) {

}
