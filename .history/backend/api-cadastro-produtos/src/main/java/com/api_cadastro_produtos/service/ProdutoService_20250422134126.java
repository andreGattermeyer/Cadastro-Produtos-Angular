package com.api_cadastro_produtos.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.model.Movimentacao;
import com.api_cadastro_produtos.model.Produto;
import com.api_cadastro_produtos.model.TipoMovimentacao;
import com.api_cadastro_produtos.repository.MovimentacaoRepository;
import com.api_cadastro_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

     // Método para cadastrar um produto no BD.
     public Produto salvarVeiculo(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * M
     * @param descricao
     * @param valor
     * @param tipo
     * @param produtoId
     */
    public void registrarMovimentacao(String descricao, BigDecimal valor, TipoMovimentacao tipo, Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao(descricao);
        movimentacao.setValor(valor);
        movimentacao.setTipo(tipo);
        movimentacao.setProduto(produto);

        movimentacaoRepository.save(movimentacao);
    }


    /**
     * Método para Calcular o lucro
     */
 public BigDecimal calcularLucro(BigDecimal precoCusto, BigDecimal precoVenda) {
        return precoVenda.subtract(precoCusto);
    }

}
