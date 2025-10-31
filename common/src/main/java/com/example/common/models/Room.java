package com.example.common.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Getter
@Setter
public class Room extends Rentable {

    private Integer number;
    private Integer capacity;

    public Room() {
        super();
    }

    public Room(Integer number, Integer capacity) {
        super();
        this.number = number;
        this.capacity = capacity;
    }
}