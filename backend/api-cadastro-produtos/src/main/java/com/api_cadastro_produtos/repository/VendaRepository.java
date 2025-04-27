package com.api_cadastro_produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_cadastro_produtos.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

}
