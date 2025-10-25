package com.example.common.dtos.simpleDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleProfessorDTO {
    private Long id;
    private String name;
    private String email;
}
