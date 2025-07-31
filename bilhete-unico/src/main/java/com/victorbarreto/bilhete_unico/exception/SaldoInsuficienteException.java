package com.victorbarreto.bilhete_unico.exception;

public class SaldoInsuficienteException extends  RuntimeException{
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
