package com.example.closedsarc.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ItemLocavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean estaReservado;

    public ItemLocavel() {
        this.estaReservado = false;
    }

    public Long getId() {
        return id;
    }

    public Boolean getEstaReservado() {
        return estaReservado;
    }

    public void setEstaReservado(Boolean estaReservado) {
        this.estaReservado = estaReservado;
    }

    public void setId(Long id) {
        this.id = id;
    }
}