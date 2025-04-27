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

    


    public Produto() {
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoCusto() {
        return this.precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public BigDecimal getPrecoVenda() {
        return this.precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public LocalDate getDataEntrada() {
        return this.dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return this.dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }
    

    public Produto(Long id, String nomeProduto, Double quantidade, BigDecimal precoCusto, BigDecimal precoVenda, LocalDate dataEntrada, LocalDate dataSaida) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Produto id(Long id) {
        setId(id);
        return this;
    }

    public Produto nomeProduto(String nomeProduto) {
        setNomeProduto(nomeProduto);
        return this;
    }

    public Produto quantidade(Double quantidade) {
        setQuantidade(quantidade);
        return this;
    }

    public Produto precoCusto(BigDecimal precoCusto) {
        setPrecoCusto(precoCusto);
        return this;
    }

    public Produto precoVenda(BigDecimal precoVenda) {
        setPrecoVenda(precoVenda);
        return this;
    }

    public Produto dataEntrada(LocalDate dataEntrada) {
        setDataEntrada(dataEntrada);
        return this;
    }

    public Produto dataSaida(LocalDate dataSaida) {
        setDataSaida(dataSaida);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(nomeProduto, produto.nomeProduto) && Objects.equals(quantidade, produto.quantidade) && Objects.equals(precoCusto, produto.precoCusto) && Objects.equals(precoVenda, produto.precoVenda) && Objects.equals(dataEntrada, produto.dataEntrada) && Objects.equals(dataSaida, produto.dataSaida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeProduto, quantidade, precoCusto, precoVenda, dataEntrada, dataSaida);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nomeProduto='" + getNomeProduto() + "'" +
            ", quantidade='" + getQuantidade() + "'" +
            ", precoCusto='" + getPrecoCusto() + "'" +
            ", precoVenda='" + getPrecoVenda() + "'" +
            ", dataEntrada='" + getDataEntrada() + "'" +
            ", dataSaida='" + getDataSaida() + "'" +
            "}";
    }
    

}
