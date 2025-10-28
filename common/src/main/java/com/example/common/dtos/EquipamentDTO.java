package com.example.common.dtos;

import java.util.List;

import com.example.common.dtos.simpleDTOs.SimpleRentDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentDTO {
    private Long id;
    private String name;
    private List<SimpleRentDTO> rents;
}
