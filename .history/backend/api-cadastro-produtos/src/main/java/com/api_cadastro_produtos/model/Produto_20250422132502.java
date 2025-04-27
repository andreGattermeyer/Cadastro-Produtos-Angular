package com.api_cadastro_produtos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeProduto;

    private Double quantidade;

     private BigDecimal precoCusto; 

    private BigDecimal precoVenda; 

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrada;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataSaida;

     @OneToMany(mappedBy = "produto")
    private List<Movimentacao> movimentacoes;

    

}
