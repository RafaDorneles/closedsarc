package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.EquipamentDTO;
import com.example.common.dtos.createDTOs.CreateEquipamentDTO;
import com.example.datagateway.exceptions.ApiException;
import com.example.common.mappers.interfaces.IEquipamentMapper;
import com.example.common.models.Equipament;
import com.example.datagateway.repositories.IEquipamentRepository;
import com.example.datagateway.services.interfaces.IEquipamentService;

@Service
public class EquipamentService implements IEquipamentService {

    @Autowired
    private IEquipamentRepository equipamentRepository;

    @Autowired
    private IEquipamentMapper equipamentMapper;

    @Override
    public List<EquipamentDTO> getAllEquipaments() {
        return equipamentRepository.findAll().stream().map(equipamentMapper::entityToDto).toList();
    }

    @Override
    public EquipamentDTO getEquipamentById(Long id) {
        return equipamentRepository.findById(id).map(equipamentMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Equipament not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public EquipamentDTO createEquipament(CreateEquipamentDTO equipament) {
        return equipamentMapper.entityToDto(equipamentRepository.save(equipamentMapper.requestToEntity(equipament)));
    }

    @Override
    public EquipamentDTO updateEquipament(CreateEquipamentDTO equipament, Long id) {
        return equipamentRepository.findById(id)
                .map(existingEquipament -> {
                    Equipament updatedEquipament = equipamentMapper.requestToEntity(equipament);
                    updatedEquipament.setId(existingEquipament.getId());
                    Equipament savedEquipament = equipamentRepository.save(updatedEquipament);
                    return equipamentMapper.entityToDto(savedEquipament);
                })
                .orElseThrow(() -> new ApiException("Equipament not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public EquipamentDTO deleteEquipament(Long id) {
        Equipament equipament = equipamentRepository.findById(id).orElseThrow(() -> new ApiException("Equipament not found", HttpStatus.NOT_FOUND));
        equipamentRepository.delete(equipament);
        return equipamentMapper.entityToDto(equipament);
    }
    
}
