package com.victorbarreto.bilhete_unico.exception;

public class TipoTransacaoInvalidoException extends RuntimeException{
    public TipoTransacaoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
