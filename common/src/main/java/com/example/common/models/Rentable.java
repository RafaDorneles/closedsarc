package com.example.common.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "rentableItems")
@Getter
@Setter
public abstract class Rentable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "rentableItem")
    private List<Rent> rents;

    public Rentable() {
        this.rents = new ArrayList<>();
    }

    public void addRent(Rent newRent){
        rents.add(newRent);
    }

    public void removeRent(Rent removedRent){
        rents.remove(removedRent);
    }
}