package com.api_cadastro_produtos.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nomeProduto;

    private Double quantidade;

    @JsonFormat(pattern = "dd/MM/yyyy")

    private LocalDate dataEntrada;

    private LocalDate dataSaida;


    public Produto() {
    }

    public Produto(Long id, String nomeProduto, Double quantidade, Date dataEntrada, Date dataSaida) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
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

    public Date getDataEntrada() {
        return this.dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return this.dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
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

    public Produto dataEntrada(Date dataEntrada) {
        setDataEntrada(dataEntrada);
        return this;
    }

    public Produto dataSaida(Date dataSaida) {
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
        return Objects.equals(id, produto.id) && Objects.equals(nomeProduto, produto.nomeProduto) && Objects.equals(quantidade, produto.quantidade) && Objects.equals(dataEntrada, produto.dataEntrada) && Objects.equals(dataSaida, produto.dataSaida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeProduto, quantidade, dataEntrada, dataSaida);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nomeProduto='" + getNomeProduto() + "'" +
            ", quantidade='" + getQuantidade() + "'" +
            ", dataEntrada='" + getDataEntrada() + "'" +
            ", dataSaida='" + getDataSaida() + "'" +
            "}";
    }
    

}

