package com.example.common.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}