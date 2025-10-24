package com.example.common.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<ClassroomDTO> classes;
}
