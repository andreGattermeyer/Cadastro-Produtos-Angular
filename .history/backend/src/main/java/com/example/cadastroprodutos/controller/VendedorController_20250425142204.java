package com.example.cadastroprodutos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
// ... outros imports ...

@RestController
@RequestMapping("/api/vendedores")
@CrossOrigin(origins = "http://localhost:4200")
public class VendedorController {
    // ... código existente ...
}