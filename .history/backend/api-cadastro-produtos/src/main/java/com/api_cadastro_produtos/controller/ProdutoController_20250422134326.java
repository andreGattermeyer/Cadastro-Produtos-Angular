package com.api_cadastro_produtos.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api_cadastro_produtos.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    PostMapping("/gravar-produto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto novoVeiculo = veiculoServico.salvarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVeiculo);
    }

    @GetMapping("/lucro")
    public ResponseEntity<String> calcularLucro(@RequestParam BigDecimal precoCusto, @RequestParam BigDecimal precoVenda) {
        BigDecimal lucro = produtoService.calcularLucro(precoCusto, precoVenda);
        return ResponseEntity.ok("Lucro: R$ " + lucro);
    }
}