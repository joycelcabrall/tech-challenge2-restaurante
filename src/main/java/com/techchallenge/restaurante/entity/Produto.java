package com.techchallenge.restaurante.entity;

import jakarta.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Double preco;

    private Boolean apenasNoLocal;

    private String caminhoFoto;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Double preco, Boolean apenasNoLocal, String caminhoFoto, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.apenasNoLocal = apenasNoLocal;
        this.caminhoFoto = caminhoFoto;
        this.restaurante = restaurante;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public Boolean getApenasNoLocal() {
        return apenasNoLocal;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setApenasNoLocal(Boolean apenasNoLocal) {
        this.apenasNoLocal = apenasNoLocal;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}