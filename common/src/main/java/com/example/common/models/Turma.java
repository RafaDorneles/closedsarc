package com.example.common.models;

import jakarta.persistence.*;
import java.util.List;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "turma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
