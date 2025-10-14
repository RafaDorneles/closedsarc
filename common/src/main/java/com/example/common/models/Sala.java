package com.example.common.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "sala")
@Getter
@Setter
public class Sala extends ItemLocavel {

    private Integer numero;
    private Long capacidade;

    @OneToMany(mappedBy = "itemLocavel")
    private List<Reserva> reservas;

    public Sala() {
        super();
    }

    public Sala(Integer numero, Long capacidade) {
        super();
        this.numero = numero;
        this.capacidade = capacidade;
    }
}