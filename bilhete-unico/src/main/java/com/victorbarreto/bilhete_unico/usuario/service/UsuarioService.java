package com.victorbarreto.bilhete_unico.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.victorbarreto.bilhete_unico.usuario.dto.UsuarioCreateDTO;
import com.victorbarreto.bilhete_unico.usuario.entity.UsuarioModel;
import com.victorbarreto.bilhete_unico.usuario.excption.UsuarioCadastradoException;
import com.victorbarreto.bilhete_unico.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel cadastrarUsuario(UsuarioCreateDTO usuarioNovo) {
        UsuarioModel usuarioModel = new UsuarioModel();

        if(usuarioRepository.existsByCpf(usuarioNovo.cpf())){
            throw new UsuarioCadastradoException("Usuario já cadastrado no sistema!");
        }

        usuarioModel.setCpf(usuarioNovo.cpf());
        usuarioModel.setNome(usuarioNovo.nome());
        usuarioModel.setDataNasc(usuarioNovo.dataNasc());

        return usuarioRepository.save(usuarioModel);
    }
}
