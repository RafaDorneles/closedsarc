package com.example.common.dtos;

import java.util.List;

import com.example.common.models.Rent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentDTO {

    private Long id;
    private String name;
    private List<Rent> rents;

}
