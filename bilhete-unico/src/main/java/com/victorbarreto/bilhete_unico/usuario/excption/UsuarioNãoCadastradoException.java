package com.victorbarreto.bilhete_unico.usuario.excption;

public class UsuarioNãoCadastradoException extends RuntimeException {
    public UsuarioNãoCadastradoException(String mensagem) {
        super(mensagem);
    }
}
