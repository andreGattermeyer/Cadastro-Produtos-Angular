package com.api_cadastro_produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api_cadastro_produtos.model.Venda;
import com.api_cadastro_produtos.service.VendaService;


@RestController
@RequestMapping("api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping("/gravar-venda")
    public ResponseEntity<Venda> criarVenda(@RequestBody Venda venda) {
        Venda novaVenda = vendaService.criarVenda(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
    }

    @GetMapping("/listar-vendas")
    public ResponseEntity<List<Venda>> obterTodasVendas() {
        List<Venda> vendas = vendaService.obterTodasVendas();
        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/buscar-venda")
    public ResponseEntity<Venda> obterVendaPorId(@RequestParam Long id) {
        Venda venda = vendaService.obterVendaPorId(id);
        if (venda != null) {
            return ResponseEntity.ok(venda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Put
    


}
