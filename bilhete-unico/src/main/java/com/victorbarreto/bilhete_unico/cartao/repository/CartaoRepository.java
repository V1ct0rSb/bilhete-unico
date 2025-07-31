package com.victorbarreto.bilhete_unico.cartao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.victorbarreto.bilhete_unico.cartao.entity.CartaoModel;

public interface CartaoRepository extends JpaRepository<CartaoModel, Long> {
    boolean existsByNumero(int numero);
}
