package com.example.common.mappers.interfaces;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.requestsDTO.ProfessorRequestDTO;
import com.example.common.models.Professor;

public interface IProfessorMapper {
    public ProfessorDTO entityToDto(Professor professor);
    public Professor dtoToEntity(ProfessorDTO professorDTO);
    public Professor requestToEntity(ProfessorRequestDTO professorRequestDTO);
}
