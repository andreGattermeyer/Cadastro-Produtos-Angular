package com.api_cadastro_produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.model.Movimentacao;
import com.api_cadastro_produtos.model.Produto;
import com.api_cadastro_produtos.model.TipoMovimentacao;
import com.api_cadastro_produtos.repository.MovimentacaoRepository;
import com.api_cadastro_produtos.repository.ProdutoRepository;

import java.math.BigDecimal;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public void registrarMovimentacao(String descricao, BigDecimal valor, TipoMovimentacao tipo, Long produtoId) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao(descricao);
        movimentacao.setValor(valor);
        movimentacao.setTipo(tipo);
        movimentacao.setProduto(produto);

        movimentacaoRepository.save(movimentacao);
    }
}
