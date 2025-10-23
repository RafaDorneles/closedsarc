package com.example.common.dtos.requestsDTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassroomRequestDTO {
    private Integer numberOfStudents;
    private String subject;
    private List<String> periods;
    private List<String> days;

}
