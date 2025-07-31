package com.victorbarreto.bilhete_unico.transacao.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.victorbarreto.bilhete_unico.cartao.entity.CartaoModel;
import com.victorbarreto.bilhete_unico.cartao.entity.TipoCartao;
import com.victorbarreto.bilhete_unico.cartao.repository.CartaoRepository;
import com.victorbarreto.bilhete_unico.exception.CartaoNaoCadastradoException;
import com.victorbarreto.bilhete_unico.exception.SaldoInsuficienteException;
import com.victorbarreto.bilhete_unico.exception.TipoCartaoInvalidoException;
import com.victorbarreto.bilhete_unico.exception.TipoTransacaoInvalidoException;
import com.victorbarreto.bilhete_unico.transacao.dto.RecargaDTO;
import com.victorbarreto.bilhete_unico.transacao.dto.UsoCartaoDTO;
import com.victorbarreto.bilhete_unico.transacao.entity.TipoTransacao;
import com.victorbarreto.bilhete_unico.transacao.entity.TransacaoModel;
import com.victorbarreto.bilhete_unico.transacao.repository.TransacaoRepository;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    public TransacaoModel efetuarRecarga(RecargaDTO recargaDTO) {
        CartaoModel cartaoModel = cartaoRepository.findByNumero(recargaDTO.numero())
                .orElseThrow(() -> new CartaoNaoCadastradoException("Número do cartão não encontrado"));

        if (recargaDTO.valor().compareTo(BigDecimal.ZERO) > 0) {
            cartaoModel.setSaldo(cartaoModel.getSaldo().add(recargaDTO.valor()));
        } else {
            throw new RuntimeException("Valor tem que ser maior que 0!");
        }

        TransacaoModel transacaoModel = new TransacaoModel();

        transacaoModel.setTipo(TipoTransacao.valueOf("RECARGA"));
        transacaoModel.setDataHora(LocalDateTime.now());
        transacaoModel.setValor(recargaDTO.valor());
        transacaoModel.setCartao(cartaoModel);

        return transacaoRepository.save(transacaoModel);
    }

    public TransacaoModel usarCartao(UsoCartaoDTO usoCartaoDTO) {
        CartaoModel cartaoModel = cartaoRepository.findByNumero(usoCartaoDTO.numero())
                .orElseThrow(() -> new CartaoNaoCadastradoException("Número do cartão não encontrado"));

        TransacaoModel transacaoModel = new TransacaoModel();

        if (usoCartaoDTO.tipoTransacao() == TipoTransacao.USO_ONIBUS || usoCartaoDTO.tipoTransacao() == TipoTransacao.USO_METRO) {
            if (cartaoModel.getSaldo().compareTo(new BigDecimal("4.40")) < 0) {
                throw new SaldoInsuficienteException("Saldo insuficiente");
            }
            if (cartaoModel.getTipo() == TipoCartao.ESTUDANTE) {
                if (cartaoModel.getSaldo().compareTo(new BigDecimal("2.20")) < 0) {
                    throw new SaldoInsuficienteException("Saldo insuficiente");
                }
                cartaoModel.setSaldo(cartaoModel.getSaldo().subtract(new BigDecimal("2.20")));
                transacaoModel.setValor(new BigDecimal("2.20"));
            } else if (cartaoModel.getTipo() == TipoCartao.COMUM) {
                if (cartaoModel.getSaldo().compareTo(new BigDecimal("4.40")) < 0) {
                    throw new SaldoInsuficienteException("Saldo insuficiente");
                }
                cartaoModel.setSaldo(cartaoModel.getSaldo().subtract(new BigDecimal("4.40")));
                transacaoModel.setValor(new BigDecimal("4.40"));
            } else if (cartaoModel.getTipo() == TipoCartao.IDOSO) {
                cartaoModel.setSaldo(cartaoModel.getSaldo().subtract(BigDecimal.ZERO));
                transacaoModel.setValor(BigDecimal.ZERO);
            } else {
                throw new TipoCartaoInvalidoException("Tipo de cartão informado é invalido");
            }
        } else {
            throw new TipoTransacaoInvalidoException("Tipo de transação informada é invalida");
        }

        transacaoModel.setTipo(usoCartaoDTO.tipoTransacao());
        transacaoModel.setDataHora(LocalDateTime.now());
        transacaoModel.setCartao(cartaoModel);

        return transacaoRepository.save(transacaoModel);
    }


    public List<TransacaoModel> exibirTransacoes(Integer numero){
        CartaoModel cartaoModel = cartaoRepository.findByNumero(numero)
                .orElseThrow(() -> new CartaoNaoCadastradoException("Número do cartão não encontrado"));

        return transacaoRepository.findByCartao(cartaoModel); // This now returns a List
    }
}
