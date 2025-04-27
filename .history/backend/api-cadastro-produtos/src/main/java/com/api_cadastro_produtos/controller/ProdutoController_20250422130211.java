package com.api_cadastro_produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/lucro")
    public ResponseEntity<String> calcularLucro(@RequestParam BigDecimal precoCusto, @RequestParam BigDecimal precoVenda) {
        BigDecimal lucro = produtoService.calcularLucro(precoCusto, precoVenda);
        return ResponseEntity.ok("Lucro: R$ " + lucro);
    }
}