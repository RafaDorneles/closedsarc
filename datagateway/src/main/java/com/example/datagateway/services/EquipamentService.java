package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.requestsDTO.EquipamentRequestDTO;
import com.example.common.exceptions.ApiException;
import com.example.common.mappers.EquipamentMapper;
import com.example.common.models.Equipament;
import com.example.datagateway.repositories.IEquipamentRepository;
import com.example.datagateway.services.interfaces.IEquipamentService;

@Service
public class EquipamentService implements IEquipamentService {

    @Autowired
    private IEquipamentRepository equipamentRepository;

    @Override
    public List<EquipamentDTO> getAllEquipaments() {
        return equipamentRepository.findAll().stream().map(EquipamentMapper::entityToDto).toList();
    }

    @Override
    public EquipamentDTO getEquipamentById(Long id) {
        return equipamentRepository.findById(id).map(EquipamentMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Equipament not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public EquipamentDTO createEquipament(EquipamentRequestDTO equipament) {
        return EquipamentMapper.entityToDto(equipamentRepository.save(EquipamentMapper.requestToEntity(equipament)));
    }

    @Override
    public EquipamentDTO updateEquipament(EquipamentRequestDTO equipament, Long id) {
        return EquipamentMapper.entityToDto(equipamentRepository.save(EquipamentMapper.requestToEntity(equipament)));
    }

    @Override
    public EquipamentDTO deleteEquipament(Long id) {
        Equipament equipament = equipamentRepository.findById(id).orElseThrow(() -> new ApiException("Equipament not found", HttpStatus.NOT_FOUND));
        equipamentRepository.delete(equipament);
        return EquipamentMapper.entityToDto(equipament);
    }
    
}
