package com.victorbarreto.bilhete_unico.usuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.victorbarreto.bilhete_unico.usuario.entity.UsuarioModel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    boolean existsByCpf(String cpf);

    Optional<UsuarioModel> findByCpf(String cpf);
}
