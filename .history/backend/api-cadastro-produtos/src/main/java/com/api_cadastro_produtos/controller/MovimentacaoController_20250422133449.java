package com.api_cadastro_produtos.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api_cadastro_produtos.model.TipoMovimentacao;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestParam String descricao, 
                                            @RequestParam BigDecimal valor, 
                                            @RequestParam TipoMovimentacao tipo, 
                                            @RequestParam Long produtoId) {
        movimentacaoService.registrarMovimentacao(descricao, valor, tipo, produtoId);
        return ResponseEntity.ok("Movimentação registrada com sucesso!");
    }
}