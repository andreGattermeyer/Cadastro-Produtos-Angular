package com.api_cadastro_produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    public Venda createVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

}
