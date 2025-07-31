package com.victorbarreto.bilhete_unico.exception;

public class CartaoNaoCadastradoException extends RuntimeException {
    public CartaoNaoCadastradoException(String mensagem) {
        super(mensagem);
    }
}
