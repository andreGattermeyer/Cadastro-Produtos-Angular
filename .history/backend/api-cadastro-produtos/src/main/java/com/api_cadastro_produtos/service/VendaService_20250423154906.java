package com.api_cadastro_produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.model.Venda;
import com.api_cadastro_produtos.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    /**
     * Método para criar uma venda
     * @param venda
     * @return
     */
    public Venda createVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

   // Método para buscar uma venda pelo id
   public Venda getVendaById(Long id) {
    return vendaRepository.findById(id).orElse(null);
   }

}
