package com.example.common.mappers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.createDTOs.CreateProfessorDTO;
import com.example.common.dtos.simpleDTOs.SimpleProfessorDTO;
import com.example.common.mappers.interfaces.IClassroomMapper;
import com.example.common.mappers.interfaces.IProfessorMapper;
import com.example.common.models.Professor;

@Component
public class ProfessorMapper implements IProfessorMapper {

    @Autowired
    private IClassroomMapper classroomMapper;

    @Override
    public ProfessorDTO entityToDto(Professor professor) {
        if (professor == null) {
            return null;
        }

        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setName(professor.getName());
        dto.setEmail(professor.getEmail());
        dto.setPassword(professor.getPassword());
        dto.setClasses(professor.getClasses().stream()
                .map(classroomMapper::entityToSimpleDto)
                .toList());

        return dto;
    }

    @Override
    public Professor requestToEntity(CreateProfessorDTO createProfessorDTO) {
        if (createProfessorDTO == null) {
            return null;
        }

        Professor professor = new Professor();
        professor.setName(createProfessorDTO.getName());
        professor.setEmail(createProfessorDTO.getEmail());
        professor.setPassword(createProfessorDTO.getPassword());
        professor.setClasses(new ArrayList<>());

        return professor;
    }
    
    @Override
    public SimpleProfessorDTO entityToSimpleDto(Professor professor) {
        if (professor == null) {
            return null;
        }
        SimpleProfessorDTO dto = new SimpleProfessorDTO();
        dto.setId(professor.getId());
        dto.setName(professor.getName());
        dto.setEmail(professor.getEmail());

        return dto;
    }
}
