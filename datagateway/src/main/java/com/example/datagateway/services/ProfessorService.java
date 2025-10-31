package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.createDTOs.CreateProfessorDTO;
import com.example.datagateway.exceptions.ApiException;
import com.example.common.mappers.interfaces.IProfessorMapper;
import com.example.datagateway.repositories.IProfessorRepository;
import com.example.datagateway.services.interfaces.IProfessorService;

@Service
public class ProfessorService implements IProfessorService {

    @Autowired
    private IProfessorRepository professorRepository;

    @Autowired
    private IProfessorMapper professorMapper;

    @Override
    public List<ProfessorDTO> getAllProfessors() {
        return professorRepository.findAll().stream().map(professorMapper::entityToDto).toList();
    }

    @Override
    public ProfessorDTO getProfessorById(Long id) {
        return professorRepository.findById(id).map(professorMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Professor not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public ProfessorDTO createProfessor(CreateProfessorDTO professor) {
        return professorMapper.entityToDto(professorRepository.save(professorMapper.requestToEntity(professor)));
    }

    @Override
    public ProfessorDTO updateProfessor(CreateProfessorDTO professor, Long id) {
        return professorRepository.findById(id)
                .map(existingProfessor -> {
                    ProfessorDTO updatedProfessor = professorMapper.entityToDto(professorRepository.save(professorMapper.requestToEntity(professor)));
                    return updatedProfessor;
                })
                .orElseThrow(() -> new ApiException("Professor not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public ProfessorDTO deleteProfessor(Long id) {
        ProfessorDTO professorDTO = professorRepository.findById(id).map(professorMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Professor not found", HttpStatus.NOT_FOUND));
        professorRepository.deleteById(id);
        return professorDTO;
    }
    
}
