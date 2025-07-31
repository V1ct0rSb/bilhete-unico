package com.victorbarreto.bilhete_unico.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.victorbarreto.bilhete_unico.usuario.dto.UsuarioCreateDTO;
import com.victorbarreto.bilhete_unico.usuario.entity.UsuarioModel;
import com.victorbarreto.bilhete_unico.exception.UsuarioCadastradoException;
import com.victorbarreto.bilhete_unico.exception.UsuarioNaoCadastradoException;
import com.victorbarreto.bilhete_unico.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    //POST
    public UsuarioModel cadastrarUsuario(UsuarioCreateDTO usuarioNovo) {
        UsuarioModel usuarioModel = new UsuarioModel();

        if (usuarioRepository.existsByCpf(usuarioNovo.cpf())) {
            throw new UsuarioCadastradoException("Usuario já cadastrado no sistema!");
        }

        usuarioModel.setNome(usuarioNovo.nome());
        usuarioModel.setCpf(usuarioNovo.cpf());
        usuarioModel.setDataNasc(usuarioNovo.dataNasc());

        return usuarioRepository.save(usuarioModel);
    }

    //GET
    public UsuarioModel buscarPorCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new UsuarioNaoCadastradoException("Cpf informado não encontrado"));
    }

    //GET
    public UsuarioModel buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoCadastradoException("Id informado não encontrado"));
    }

    //GET
    public List<UsuarioModel> listarUsuarios(){
        return usuarioRepository.findAll();
    }


}
