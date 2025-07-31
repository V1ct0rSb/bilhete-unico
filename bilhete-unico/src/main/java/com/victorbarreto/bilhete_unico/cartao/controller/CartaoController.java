package com.victorbarreto.bilhete_unico.cartao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.victorbarreto.bilhete_unico.cartao.dto.CartaoCreateDTO;
import com.victorbarreto.bilhete_unico.cartao.dto.CartaoDadosDTO;
import com.victorbarreto.bilhete_unico.cartao.entity.CartaoModel;
import com.victorbarreto.bilhete_unico.cartao.service.CartaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    @PostMapping("/cartoes")
    public ResponseEntity<CartaoModel> cadastrarCartao(@Valid @RequestBody CartaoCreateDTO cartaoNovo) {
        CartaoModel cartaoModel = cartaoService.cadastrarCartao(cartaoNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoModel);
    }

    @GetMapping("/cartoes/{numero}")
    public ResponseEntity<CartaoDadosDTO> exibirCartao(@PathVariable Integer numero) {
        CartaoDadosDTO cartaoDadosDTO = cartaoService.exibirCartao(numero);
        return ResponseEntity.ok().body(cartaoDadosDTO);
    }
}
