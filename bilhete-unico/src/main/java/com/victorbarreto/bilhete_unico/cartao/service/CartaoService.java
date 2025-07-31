package com.victorbarreto.bilhete_unico.cartao.service;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.victorbarreto.bilhete_unico.cartao.dto.CartaoCreateDTO;
import com.victorbarreto.bilhete_unico.cartao.dto.CartaoDadosDTO;
import com.victorbarreto.bilhete_unico.cartao.entity.CartaoModel;
import com.victorbarreto.bilhete_unico.cartao.entity.TipoCartao;
import com.victorbarreto.bilhete_unico.cartao.repository.CartaoRepository;
import com.victorbarreto.bilhete_unico.usuario.entity.UsuarioModel;
import com.victorbarreto.bilhete_unico.usuario.excption.UsuarioNãoCadastradoException;
import com.victorbarreto.bilhete_unico.usuario.repository.UsuarioRepository;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public CartaoModel cadastrarCartao(CartaoCreateDTO cartaoNovo) {
        CartaoModel cartaoModel = new CartaoModel();

        UsuarioModel usuarioEncontrado = usuarioRepository.findById(cartaoNovo.idUsuario())
                .orElseThrow(() -> new UsuarioNãoCadastradoException("Id do usuário informado não encontrado!"));

        cartaoModel.setTipo(cartaoNovo.tipo());

        cartaoModel.setUsuario(usuarioEncontrado);

        cartaoModel.setNumero(gerarNumCartao());
        cartaoModel.setSaldo(BigDecimal.ZERO);
        cartaoModel.setStatus(true);

        return cartaoRepository.save(cartaoModel);
    }

    private Integer gerarNumCartao() {
        int numero;
        int tentativa = 0;

        do {
            numero = 1000 + new Random().nextInt(9000);
            tentativa++;
            if (tentativa > 1000) {
                throw new RuntimeException("Não foi possivel gerar um numero de conta!!");
            }
        } while (cartaoRepository.existsByNumero(numero));
        return numero;
    }

    //GET
    public CartaoDadosDTO exibirCartao(Integer numero) {
        CartaoModel cartaoModel = cartaoRepository.findByNumero(numero)
                .orElseThrow(() -> new RuntimeException("Numero informado não cadastrado"));

        UsuarioModel usuario = cartaoModel.getUsuario();
        BigDecimal saldo = cartaoModel.getSaldo();
        Boolean status = cartaoModel.getStatus();
        TipoCartao tipo = cartaoModel.getTipo();

        return new CartaoDadosDTO(saldo, status, tipo, usuario.getNome());


    }
}
