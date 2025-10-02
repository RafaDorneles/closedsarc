package com.example.closedsarc.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipamento")
public class Equipamento extends ItemLocavel {

    private String nome;

    public Equipamento() {
        super();
    }

    public Equipamento(String nome) {
        super();
        this.nome = nome;
    }

    @OneToMany(mappedBy = "itemLocavel")
    private List<Reserva> reservas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}