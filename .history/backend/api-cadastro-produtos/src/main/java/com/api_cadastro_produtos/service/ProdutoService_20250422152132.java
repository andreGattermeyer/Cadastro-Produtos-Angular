package com.api_cadastro_produtos.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.model.Produto;
import com.api_cadastro_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

     // Método para cadastrar um produto no BD.
     @PostMapping
     public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
     }
     
     




}
