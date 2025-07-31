package com.victorbarreto.bilhete_unico.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.victorbarreto.bilhete_unico.usuario.dto.UsuarioCreateDTO;
import com.victorbarreto.bilhete_unico.usuario.entity.UsuarioModel;
import com.victorbarreto.bilhete_unico.usuario.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@Valid @RequestBody UsuarioCreateDTO usuarioNovo) {
        UsuarioModel usuarioModel = usuarioService.cadastrarUsuario(usuarioNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModel);
    }
}
