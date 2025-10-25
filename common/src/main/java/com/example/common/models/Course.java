package com.example.common.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Supposed to be Class, but it's a reserved word in Java
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numberOfStudents;

    @Column(nullable = false)
    private String subject;

    @Enumerated(EnumType.STRING)
    private List<Period> periods;

    @Enumerated(EnumType.STRING)
    private List<Day> days;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @OneToMany(mappedBy = "course")
    private List<Rent> rents;

    public void addRent(Rent newRent){
        rents.add(newRent);
    }

    public void removeRent(Rent removedRent){
        rents.remove(removedRent);
    }

}
