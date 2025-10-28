package com.example.common.dtos;

import java.util.List;

import com.example.common.dtos.simpleDTOs.SimpleProfessorDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private Integer numberOfStudents;
    private String subject;
    private List<String> periods;
    private List<String> days;
    private SimpleProfessorDTO professor;
    private List<RentDTO> rents;

}
