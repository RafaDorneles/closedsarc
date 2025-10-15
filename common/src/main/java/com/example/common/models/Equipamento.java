package com.example.common.models;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "equipamento")
@Getter
@Setter
public class Equipamento extends ItemLocavel {

    private String nome;

    public Equipamento() {
        super();
    }

    public Equipamento(String nome) {
        super();
        this.nome = nome;
    }
}