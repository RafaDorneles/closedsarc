package com.example.common.models;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "equipements")
@Getter
@Setter
public class Equipement extends Rentable {

    private String name;

    public Equipement() {
        super();
    }

    public Equipement(String name) {
        super();
        this.name = name;
    }
}