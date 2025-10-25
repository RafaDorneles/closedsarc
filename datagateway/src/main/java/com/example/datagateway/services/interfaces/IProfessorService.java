package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.dtos.ProfessorDTO;
import com.example.common.dtos.createDTOs.CreateProfessorDTO;

public interface IProfessorService {
    List<ProfessorDTO> getAllProfessors();
    ProfessorDTO getProfessorById(Long id);
    ProfessorDTO createProfessor(CreateProfessorDTO professor);
    ProfessorDTO updateProfessor(CreateProfessorDTO professor, Long id);
    ProfessorDTO deleteProfessor(Long id);
}
