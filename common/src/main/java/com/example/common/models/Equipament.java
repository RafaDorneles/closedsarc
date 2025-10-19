package com.example.common.models;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "equipaments")
@Getter
@Setter
public class Equipament extends Rentable {

    private String name;

    public Equipament() {
        super();
    }

    public Equipament(String name) {
        super();
        this.name = name;
    }
}