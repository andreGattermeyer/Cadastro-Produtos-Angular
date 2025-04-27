package com.api_cadastro_produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_cadastro_produtos.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long>{
    List<Movimentacao> findByDescricaoContaining(String descricao);

}
