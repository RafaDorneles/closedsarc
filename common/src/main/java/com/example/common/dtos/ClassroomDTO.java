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
public class ClassroomDTO {
    private Long id;
    private Integer numberOfStudents;
    private String subject;
    private List<String> periods;
    private List<String> days;
    private ProfessorDTO professor;
    private List<RentDTO> rents;

}
