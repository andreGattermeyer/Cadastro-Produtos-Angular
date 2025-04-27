package com.api_cadastro_produtos.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    /**
     * Calcular o lucro
     */
 public BigDecimal calcularLucro(BigDecimal precoCusto, BigDecimal precoVenda) {
        return precoVenda.subtract(precoCusto);
    }

}
