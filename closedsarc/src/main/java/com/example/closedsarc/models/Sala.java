package com.example.closedsarc.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sala")
public class Sala extends ItemLocavel {

    private Integer numero;
    private Long capacidade;

    @OneToMany(mappedBy = "sala")
    private List<Reserva> reservas;

    public Sala() {
        super();
    }

    public Sala(Integer numero, Long capacidade) {
        super();
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Long capacidade) {
        this.capacidade = capacidade;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

}