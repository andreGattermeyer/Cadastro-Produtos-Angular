package com.api_cadastro_produtos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nomeProduto;

    private Double quantidade;

    private Date
}

