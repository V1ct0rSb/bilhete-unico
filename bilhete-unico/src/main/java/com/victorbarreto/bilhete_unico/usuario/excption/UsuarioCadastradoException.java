package com.victorbarreto.bilhete_unico.usuario.excption;

public class UsuarioCadastradoException extends RuntimeException {
    public UsuarioCadastradoException(String mensagem) {
        super(mensagem);
    }
}
