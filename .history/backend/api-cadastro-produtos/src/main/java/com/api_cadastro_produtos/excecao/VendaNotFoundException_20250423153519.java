package com.api_cadastro_produtos.excecao;

public class VendaNotFoundException extends Exception{
    public VendaNotFoundException(String message) {
        super(message);
    }
}
