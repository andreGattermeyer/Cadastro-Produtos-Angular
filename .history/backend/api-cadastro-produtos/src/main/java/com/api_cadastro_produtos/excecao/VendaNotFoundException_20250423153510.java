package com.api_cadastro_produtos.excecao;

public class VendaNotFoundException extends Exception{
    public ProdutoNotFoundException(String message) {
        super(message);
    }
}
