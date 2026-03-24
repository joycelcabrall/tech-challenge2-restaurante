package com.techchallenge.restaurante.entity;

import jakarta.persistence.*;

@Entity
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTipo;

    public TipoUsuario() {}

    public Long getId() {
        return id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }
}