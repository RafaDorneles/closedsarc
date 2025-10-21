package com.example.common.dtos;

import com.example.common.models.Period;

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
    private Period period;
    

}
