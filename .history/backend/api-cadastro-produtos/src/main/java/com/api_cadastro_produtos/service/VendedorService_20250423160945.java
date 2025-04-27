package com.api_cadastro_produtos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.model.Vendedor;
import com.api_cadastro_produtos.repository.VendedorRepository;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    // Método para salvar um vendedor
    public Vendedor salvarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    // Método para listar todos os vendedores
    public List<Vendedor> buscarTodosVendedores() {
        return vendedorRepository.findAll();
    }

    // Método para buscar um vendedor pelo ID
    public Vendedor buscarVendedorPorId(Long id) {
        Optional<Vendedor> optVendedor = vendedorRepository.findById(id);
        if (optVendedor.isPresent()) {
            return optVendedor.get();
        } else {
            throw new RuntimeException("Vendedor com id: " + id + " não existe");
        }
    }

    // Método para atualizar um vendedor
    public Vendedor atualizarVendedor(Long id, Vendedor vendedorAtualizado) {
        Optional<Vendedor> optVendedor = vendedorRepository.findById(id);
        if (optVendedor.isPresent()) {
            Vendedor vendedor = optVendedor.get();
            vendedor.setNome(vendedorAtualizado.getNome());
            vendedor.setEmail(vendedorAtualizado.getEmail());
            vendedor.setTelefone(vendedorAtualizado.getTelefone());
            
            return vendedorRepository.save(vendedor);
        }
        throw new RuntimeException("Vendedor com id: " + id + " não existe");
    }

    // Método para apagar um vendedor
    public void apagarVendedor(Long id) {
        Vendedor vendedor = buscarVendedorPorId(id);
        vendedorRepository.delete(vendedor);
    }
}
