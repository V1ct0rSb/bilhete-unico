package com.victorbarreto.bilhete_unico.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_transacoes")
public class TransacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private TipoTransacao tipo;
    private LocalDate dataHora;

    @ManyToOne
    @JoinColumn(name = "cartao_id")
    private CartaoModel cartao;

    public TransacaoModel() {
    }

    public TransacaoModel(CartaoModel cartao, LocalDate dataHora, TipoTransacao tipo, BigDecimal valor) {
        this.cartao = cartao;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.valor = valor;
    }

    public CartaoModel getCartao() {
        return cartao;
    }

    public void setCartao(CartaoModel cartao) {
        this.cartao = cartao;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
