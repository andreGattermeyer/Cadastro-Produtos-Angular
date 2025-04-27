package com.api_cadastro_produtos.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

     // Método para cadastrar um veículo no BD.
     public Produto salvarVeiculo(Veiculo veiculo) {
        return veiculoRepositorio.save(veiculo);
    }

    /**
     * Método para Calcular o lucro
     */
 public BigDecimal calcularLucro(BigDecimal precoCusto, BigDecimal precoVenda) {
        return precoVenda.subtract(precoCusto);
    }

}
