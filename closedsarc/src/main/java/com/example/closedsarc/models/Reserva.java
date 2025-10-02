package com.example.closedsarc.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turmaID", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "itemLocavelID", nullable = false)
    private ItemLocavel itemLocavel;

    @Column(nullable = false)
    private LocalDateTime data;

    public Reserva() {
    }

    public Reserva(Turma turma, ItemLocavel itemLocavel, LocalDateTime data) {
        this.turma = turma;
        this.itemLocavel = itemLocavel;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public ItemLocavel getItemLocavel() {
        return itemLocavel;
    }

    public void setItemLocavel(ItemLocavel itemLocavel) {
        this.itemLocavel = itemLocavel;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }


    
}