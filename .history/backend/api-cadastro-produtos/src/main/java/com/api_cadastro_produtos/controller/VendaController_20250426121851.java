package com.api_cadastro_produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_cadastro_produtos.model.Venda;
import com.api_cadastro_produtos.service.VendaService;
import com.api_cadastro_produtos.model.Vendedor;
import com.api_cadastro_produtos.service.VendedorService;

@RestController
@RequestMapping("api/vendas")
@CrossOrigin(origins = "http://localhost:4200")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<Venda> registrarVenda(@RequestBody Venda venda) {
        try {
            Venda novaVenda = vendaService.registrarVenda(venda);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Venda>> buscarTodasVendas() {
        List<Venda> vendas = vendaService.buscarTodasVendas();
        
        // Garantir que cada venda tenha o vendedor associado
        for (Venda venda : vendas) {
            if (venda.getVendedor() == null && venda.getVendedorId() != null) {
                // Buscar o vendedor pelo ID e associá-lo à venda
                try {
                    // Você precisará injetar o VendedorService
                    Vendedor vendedor = vendedorService.buscarVendedorPorId(venda.getVendedorId());
                    venda.setVendedor(vendedor);
                } catch (Exception e) {
                    // Log do erro, mas continua o processamento
                    System.err.println("Erro ao buscar vendedor para a venda " + venda.getId() + ": " + e.getMessage());
                }
            }
        }
        
        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarVendaPorId(@PathVariable Long id) {
        try {
            Venda venda = vendaService.buscarVendaPorId(id);
            return ResponseEntity.ok(venda);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/vendedor/{id}")
    public ResponseEntity<List<Venda>> buscarVendasPorVendedor(@PathVariable Long id) {
        try {
            List<Venda> vendas = vendaService.buscarVendasPorVendedor(id);
            return ResponseEntity.ok(vendas);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/produto/{id}")
    public ResponseEntity<List<Venda>> buscarVendasPorProduto(@PathVariable Long id) {
        try {
            List<Venda> vendas = vendaService.buscarVendasPorProduto(id);
            return ResponseEntity.ok(vendas);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarVenda(@PathVariable Long id) {
        try {
            vendaService.cancelarVenda(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
