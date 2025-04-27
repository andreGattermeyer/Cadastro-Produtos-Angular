package com.api_cadastro_produtos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.model.Produto;
import com.api_cadastro_produtos.model.Venda;
import com.api_cadastro_produtos.model.Vendedor;
import com.api_cadastro_produtos.repository.ProdutoRepository;
import com.api_cadastro_produtos.repository.VendaRepository;
import com.api_cadastro_produtos.repository.VendedorRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private VendedorRepository vendedorRepository;

    // Método para registrar uma venda
    public Venda registrarVenda(Venda venda) {
        // Verificar se o produto existe
        Optional<Produto> optProduto = produtoRepository.findById(venda.getProduto().getId());
        if (!optProduto.isPresent()) {
            throw new RuntimeException("Produto não encontrado");
        }
        
        // Verificar se o vendedor existe
        Optional<Vendedor> optVendedor = vendedorRepository.findById(venda.getVendedor().getId());
        if (!optVendedor.isPresent()) {
            throw new RuntimeException("Vendedor não encontrado");
        }
        
         // Associar o vendedor completo à venda
        venda.setVendedor(optVendedor.get());

        Produto produto = optProduto.get();
        
        // Verificar se há estoque suficiente
        if (produto.getQuantidade() < venda.getQuantidade()) {
            throw new RuntimeException("Quantidade insuficiente em estoque");
        }
        
        // Atualizar o estoque do produto
        produto.setQuantidade(produto.getQuantidade() - venda.getQuantidade());
        produto.setDataSaida(LocalDateTime.now());
        produtoRepository.save(produto);
        
        // Definir a data da venda
        venda.setDataVenda(LocalDateTime.now());
        
        return vendaRepository.save(venda);
    }

    // Método para listar todas as vendas
    public List<Venda> buscarTodasVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        
        // Garantir que cada venda tenha o vendedor associado
        for (Venda venda : vendas) {
            if (venda.getVendedor() != null) {
                // Forçar o carregamento do vendedor (evita problemas de lazy loading)
                venda.getVendedor().getNome();
            }
        }
        
        return vendas;
    }

    // Método para buscar uma venda pelo ID
    public Venda buscarVendaPorId(Long id) {
        Optional<Venda> optVenda = vendaRepository.findById(id);
        if (optVenda.isPresent()) {
            return optVenda.get();
        } else {
            throw new RuntimeException("Venda com id: " + id + " não existe");
        }
    }
    
    // Método para buscar vendas por vendedor
    public List<Venda> buscarVendasPorVendedor(Long vendedorId) {
        // Verificar se o vendedor existe
        Vendedor vendedor = vendedorRepository.findById(vendedorId)
            .orElseThrow(() -> new RuntimeException("Vendedor não encontrado"));
            
        // Buscar todas as vendas e filtrar pelo vendedor
        return vendaRepository.findAll().stream()
            .filter(venda -> venda.getVendedor() != null && 
                   venda.getVendedor().getId().equals(vendedorId))
            .collect(Collectors.toList());
    }
    
    // Método para buscar vendas por produto
    public List<Venda> buscarVendasPorProduto(Long produtoId) {
        // Implementação depende de um método no repository
        // Você pode adicionar um método findByProdutoId no VendaRepository
        return vendaRepository.findAll().stream()
            .filter(venda -> venda.getProduto().getId().equals(produtoId))
            .toList();
    }
    
    // Método para cancelar uma venda
    public void cancelarVenda(Long id) {
        Venda venda = buscarVendaPorId(id);
        
        // Devolver a quantidade ao estoque
        Produto produto = venda.getProduto();
        produto.setQuantidade(produto.getQuantidade() + venda.getQuantidade());
        produtoRepository.save(produto);
        
        // Remover a venda
        vendaRepository.delete(venda);
    }
}
