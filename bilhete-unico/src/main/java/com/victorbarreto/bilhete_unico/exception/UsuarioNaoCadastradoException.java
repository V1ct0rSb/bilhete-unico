package com.victorbarreto.bilhete_unico.exception;

public class UsuarioNaoCadastradoException extends RuntimeException {
    public UsuarioNaoCadastradoException(String mensagem) {
        super(mensagem);
    }
}
