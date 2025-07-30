package com.victorbarreto.bilhete_unico.usuario.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.victorbarreto.bilhete_unico.cartao.entity.CartaoModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    private Date dataNasc;

    @OneToMany(mappedBy = "usuario")
    private List<CartaoModel> cartoes = new ArrayList<>();

    public UsuarioModel() {
    }

    public UsuarioModel(List<CartaoModel> cartoes, Date dataNasc, String cpf, String nome) {
        this.cartoes = cartoes;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.nome = nome;
    }

    public List<CartaoModel> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<CartaoModel> cartoes) {
        this.cartoes = cartoes;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
