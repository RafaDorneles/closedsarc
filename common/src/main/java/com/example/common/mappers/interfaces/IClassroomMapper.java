package com.example.common.mappers.interfaces;

import com.example.common.dtos.ClassroomDTO;
import com.example.common.dtos.requestsDTO.ClassroomRequestDTO;
import com.example.common.models.Classroom;

public interface IClassroomMapper {
    public ClassroomDTO entityToDto(Classroom classroom);
    public Classroom dtoToEntity(ClassroomDTO classroomDTO);
    public Classroom requestToEntity(ClassroomRequestDTO roomRequestDTO);
}
