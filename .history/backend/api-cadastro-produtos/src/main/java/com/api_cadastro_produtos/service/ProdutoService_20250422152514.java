package com.api_cadastro_produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_cadastro_produtos.model.Produto;
import com.api_cadastro_produtos.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public BigDecimal calcularMargemLucroProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produto.get().calcularMargemLucro();
        }
        throw new RuntimeException("Produto não encontrado");
    }
}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
     
     @GetMapping("/listar-produtos")
     List<Produto> listarProdutos() {
        return produtoRepository.findAll();
     }



}
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org
