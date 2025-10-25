package com.example.common.mappers.interfaces;

import com.example.common.dtos.ClassroomDTO;
import com.example.common.dtos.createDTOs.CreateClassroomDTO;
import com.example.common.dtos.simpleDTOs.SimpleClassroomDTO;
import com.example.common.models.Classroom;

public interface IClassroomMapper {
    public ClassroomDTO entityToDto(Classroom classroom);
    public Classroom requestToEntity(CreateClassroomDTO roomRequestDTO);
    public SimpleClassroomDTO entityToSimpleDto(Classroom classroom);
}
