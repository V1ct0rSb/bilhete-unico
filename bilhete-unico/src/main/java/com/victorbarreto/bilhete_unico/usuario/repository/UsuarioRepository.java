package com.victorbarreto.bilhete_unico.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.victorbarreto.bilhete_unico.usuario.entity.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    boolean existsByCpf(String cpf);
}
