package com.victorbarreto.bilhete_unico.exception;

public class TipoCartaoInvalidoException extends RuntimeException{

    public TipoCartaoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
