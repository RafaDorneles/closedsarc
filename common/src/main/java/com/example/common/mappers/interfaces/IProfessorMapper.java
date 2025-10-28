package com.example.common.mappers.interfaces;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.createDTOs.CreateProfessorDTO;
import com.example.common.dtos.simpleDTOs.SimpleProfessorDTO;
import com.example.common.models.Professor;

public interface IProfessorMapper {
    public ProfessorDTO entityToDto(Professor professor);
    public Professor requestToEntity(CreateProfessorDTO createProfessorDTO);
    public SimpleProfessorDTO entityToSimpleDto(Professor professor);
}
