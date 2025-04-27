package com.api_cadastro_produtos.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.api_cadastro_produtos.excecao.ProdutoNotFoundException;
import com.api_cadastro_produtos.model.Produto;
import com.api_cadastro_produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método para cadastrar um produto no BD.
    @PostMapping("/gravar-produto")
    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    /**
     * Método para listar todos os produtos.
     *
     * @return List<Produto>
     */
    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    // Método para buscar um produto pelo seu ID.
    public Produto buscarProdutoPorId(Long id) throws ProdutoNotFoundException {
        Optional<Produto> opt = produtoRepository.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new ProdutoNotFoundException("Produto com id : " + id + " não existe");
        }
    }

    // Método para atualizar um produto
    public Produto atualizarProduto(Long id, Produto produtoAtualizado) throws ProdutoNotFoundException {
      Optional<Produto> optProduto = produtoRepository.findById(id);
      if (optProduto.isPresent()) {
          Produto produto = optProduto.get();
          produto.setNomeProduto(produtoAtualizado.getNomeProduto());
          produto.setQuantidade(produtoAtualizado.getQuantidade());
          produto.setPrecoCusto(produtoAtualizado.getPrecoCusto());
          produto.setPrecoVenda(produtoAtualizado.getPrecoVenda());
          produto.setDataEntrada(produtoAtualizado.getDataEntrada());
          produto.setDataSaida(produtoAtualizado.getDataSaida());
          
          return produtoRepository.save(produto);
      }
      throw new ProdutoNotFoundException("Produto com id : " + id + " não existe");
  }


    // Método para reduzir a quantidade de um produto.
    public Produto reduzirQuantidade(Long id, Double quantidadeAReduzir) throws ProdutoNotFoundException {
        Optional<Produto> optProduto = produtoRepository.findById(id);
        if (optProduto.isPresent()) {
            Produto produto = optProduto.get();
            
            if (produto.getQuantidade() >= quantidadeAReduzir) {
                produto.setQuantidade(produto.getQuantidade() - quantidadeAReduzir);
                return produtoRepository.save(produto);
            } else {
                throw new RuntimeException("Quantidade a reduzir é maior que a quantidade disponível");
            }
        }
        throw new ProdutoNotFoundException("Produto com id : " + id + " não existe");
    }

    public BigDecimal calcularMargemLucroProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produto.get().calcularMargemLucro();
        }
        throw new RuntimeException("Produto não encontrado");
    }

    public Produto registrarSaidaProduto(Long id, Double quantidadeSaida) throws ProdutoNotFoundException {
        Optional<Produto> optProduto = produtoRepository.findById(id);
        if (optProduto.isPresent()) {
            Produto produto = optProduto.get();
            
            if (produto.getQuantidade() >= quantidadeSaida) {
                produto.setQuantidade(produto.getQuantidade() - quantidadeSaida);
                produto.setDataSaida(LocalDateTime.now()); // Registra data e hora atual
                return produtoRepository.save(produto);
            } else {
                throw new RuntimeException("Quantidade de saída maior que a quantidade disponível em estoque");
            }
        }
        throw new ProdutoNotFoundException("Produto com id : " + id + " não existe");
    }

     /* Método para apagar o produto pelo seu ID.*/
     public void apagarProduto(Long id) throws VeiculoNotFoundException {
        Veiculo veiculo = buscarVeiculoPorId(id);
        veiculoRepositorio.delete(veiculo);
    }

}
