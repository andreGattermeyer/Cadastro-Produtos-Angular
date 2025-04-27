package com.api_cadastro_produtos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @
    private Long id;

    private String nomeProduto;

    private Double quantidade;
}

