package com.example.closedsarc.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantidade;

    @Column(nullable = false)
    private String disciplina;

    @Enumerated(EnumType.STRING)
    private Periodo periodo;

    private Long dias;

    @ManyToOne
    @JoinColumn(name = "professorID", nullable = false)
    private Professor professor;

    @OneToMany(mappedBy = "turma")
    private List<Reserva> reservas;

    public Turma() {
    }

    public Turma(Long quantidade, String disciplina, Periodo periodo, Long dias, Professor professor) {
        this.quantidade = quantidade;
        this.disciplina = disciplina;
        this.periodo = periodo;
        this.dias = dias;
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Long getDias() {
        return dias;
    }

    public void setDias(Long dias) {
        this.dias = dias;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    

}
