package com.example.common.dtos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipamentDTO {
    private String name;
    private List<Long> rentIds;

}
