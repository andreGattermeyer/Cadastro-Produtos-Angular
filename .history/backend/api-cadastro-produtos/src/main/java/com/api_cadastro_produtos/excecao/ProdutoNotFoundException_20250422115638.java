package com.api_cadastro_produtos.excecao;

public class ProdutoNotFoundException extends Exception{
    public ProdutoNotFoundException(String message) {
        super(message);
    }
}
