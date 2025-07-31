package com.victorbarreto.bilhete_unico.transacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.victorbarreto.bilhete_unico.transacao.dto.RecargaDTO;
import com.victorbarreto.bilhete_unico.transacao.dto.UsoCartaoDTO;
import com.victorbarreto.bilhete_unico.transacao.entity.TransacaoModel;
import com.victorbarreto.bilhete_unico.transacao.service.TransacaoService;

@RestController
@RequestMapping(value = "/api")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao/recarga")
    public ResponseEntity<TransacaoModel> efetuarRecarga(@RequestBody RecargaDTO recargaDTO) {
        TransacaoModel transacaoModel = transacaoService.efetuarRecarga(recargaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoModel);
    }

    @PostMapping("/trasacao/cartao")
    public ResponseEntity<TransacaoModel> usarCartao(@RequestBody UsoCartaoDTO usoCartaoDTO) {
        TransacaoModel transacaoModel = transacaoService.usarCartao(usoCartaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoModel);
    }

    @GetMapping("/transacoes/cartao/{numero}")
    public ResponseEntity<List<TransacaoModel>> exibirTransacoes(@PathVariable Integer numero) {
        List<TransacaoModel> transacoes = transacaoService.exibirTransacoes(numero);
        return ResponseEntity.ok().body(transacoes);
    }

}
