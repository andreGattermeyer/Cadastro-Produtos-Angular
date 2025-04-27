package com.api_cadastro_produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    /**
     * 
     * @param venda
     * @return
     */
    public Venda createVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

}
