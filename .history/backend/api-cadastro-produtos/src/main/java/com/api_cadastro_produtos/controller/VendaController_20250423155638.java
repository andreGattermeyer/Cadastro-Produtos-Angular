package com.api_cadastro_produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_cadastro_produtos.service.VendaService;

@RestController
@RequestMapping("api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/gravar-venda")
    public ResponseEntity<Venda> salvarVenda(@RequestBody Venda venda) {
        Venda novaVenda = vendaService.salvarVenda(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
    }


}
