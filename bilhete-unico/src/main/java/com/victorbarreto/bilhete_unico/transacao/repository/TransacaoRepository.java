package com.victorbarreto.bilhete_unico.transacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.victorbarreto.bilhete_unico.cartao.entity.CartaoModel;
import com.victorbarreto.bilhete_unico.transacao.entity.TransacaoModel;

public interface TransacaoRepository extends JpaRepository<TransacaoModel, Long> {
    List<TransacaoModel> findByCartao(CartaoModel cartaoModel);
}
