package com.victorbarreto.bilhete_unico.exception;

public class UsuarioCadastradoException extends RuntimeException {
    public UsuarioCadastradoException(String mensagem) {
        super(mensagem);
    }
}
