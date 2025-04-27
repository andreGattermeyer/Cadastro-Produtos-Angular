package com.api_cadastro_produtos.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api_cadastro_produtos.excecao.ProdutoNotFoundException;
import com.api_cadastro_produtos.model.Produto;
import com.api_cadastro_produtos.service.ProdutoService;

@RestController
@RequestMapping("api/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/gravar-produto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @GetMapping("/listar-produtos")
    public ResponseEntity<List<Produto>> buscarTodosProdutos() {
        List<Produto> produtos = produtoService.buscarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        try {
            Produto produto = produtoService.buscarProdutoPorId(id);
            return ResponseEntity.ok(produto);
        } catch (ProdutoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(
            @PathVariable Long id,
            @RequestBody Produto produto) {
        try {
            Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
            return ResponseEntity.ok(produtoAtualizado);
        } catch (ProdutoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/reduzir-quantidade")
    public ResponseEntity<Produto> reduzirQuantidade(
            @PathVariable Long id,
            @RequestParam Double quantidade) {
        try {
            Produto produto = produtoService.reduzirQuantidade(id, quantidade);
            return ResponseEntity.ok(produto);
        } catch (ProdutoNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/registrar-saida")
    public ResponseEntity<Produto> registrarSaidaProduto(
            @PathVariable Long id,
            @RequestParam Double quantidade) {
        try {
            Produto produto = produtoService.registrarSaidaProduto(id, quantidade);
            return ResponseEntity.ok(produto);
        } catch (ProdutoNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

     @GetMapping("/{id}/margem-lucro")
    public ResponseEntity<BigDecimal> calcularMargemLucro(@PathVariable Long id) {
        try {
            BigDecimal margemLucro = produtoService.calcularMargemLucroProduto(id);
            return ResponseEntity.ok(margemLucro);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

        @DeleteMapping("/deletar/produto/{id}")
    public ResponseEntity<Void> apagarProduto(@PathVariable Long id) {
        try {
            produto.apagarVeiculo(id);
            return ResponseEntity.noContent().build();
        } catch (VeiculoNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
