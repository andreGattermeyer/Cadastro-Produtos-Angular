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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_cadastro_produtos.model.Vendedor;
import com.api_cadastro_produtos.service.VendedorService;

@RestController
@RequestMapping("api/vendedores")
@CrossOrigin(origins = "http://localhost:4200")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<Vendedor> salvarVendedor(@RequestBody Vendedor vendedor) {
        Vendedor novoVendedor = vendedorService.salvarVendedor(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoVendedor);
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> buscarTodosVendedores() {
        List<Vendedor> vendedores = vendedorService.buscarTodosVendedores();
        return ResponseEntity.ok(vendedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> buscarVendedorPorId(@PathVariable Long id) {
        try {
            Vendedor vendedor = vendedorService.buscarVendedorPorId(id);
            return ResponseEntity.ok(vendedor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> atualizarVendedor(
            @PathVariable Long id,
            @RequestBody Vendedor vendedor) {
        try {
            Vendedor vendedorAtualizado = vendedorService.atualizarVendedor(id, vendedor);
            return ResponseEntity.ok(vendedorAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarVendedor(@PathVariable Long id) {
        try {
            vendedorService.apagarVendedor(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
