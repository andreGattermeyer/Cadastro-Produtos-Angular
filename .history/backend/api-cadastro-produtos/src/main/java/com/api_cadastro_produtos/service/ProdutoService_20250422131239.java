package com.api_cadastro_produtos.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {


    @Autowired
    private Produto

    /**
     * Método para Calcular o lucro
     */
 public BigDecimal calcularLucro(BigDecimal precoCusto, BigDecimal precoVenda) {
        return precoVenda.subtract(precoCusto);
    }

}
