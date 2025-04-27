package com.api_cadastro_produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_cadastro_produtos.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}
