package com.api_cadastro_produtos.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.api_cadastro_produtos.excecao.ProdutoNotFoundException;
import com.api_cadastro_produtos.model.Produto;
import com.api_cadastro_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método para cadastrar um produto no BD.
    @PostMapping("/gravar-produto")
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * Método para listar todos os produtos.
     *
     * @return List<Produto>
     */
    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    // Método para buscar um produto pelo seu ID.
    public Produto buscarProdutoPorId(Long id) throws ProdutoNotFoundException {
        Optional<Produto> opt = produtoRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new ProdutoNotFoundException("Produto com id : " + id + " não existe");
        }
    }

    public BigDecimal calcularMargemLucroProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produto.get().calcularMargemLucro();
        }
        throw new RuntimeException("Produto não encontrado");
    }

}
