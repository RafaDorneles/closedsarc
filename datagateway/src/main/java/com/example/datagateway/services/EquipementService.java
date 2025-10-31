package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.dtos.EquipementDTO;
import com.example.common.dtos.createDTOs.CreateEquipementDTO;
import com.example.datagateway.exceptions.ApiException;
import com.example.common.mappers.interfaces.IEquipementMapper;
import com.example.common.models.Equipement;
import com.example.datagateway.repositories.IEquipementRepository;
import com.example.datagateway.services.interfaces.IEquipementService;

@Service
public class EquipementService implements IEquipementService {

    @Autowired
    private IEquipementRepository equipementRepository;

    @Autowired
    private IEquipementMapper equipementMapper;

    @Override
    public List<EquipementDTO> getAllEquipements() {
        return equipementRepository.findAll().stream().map(equipementMapper::entityToDto).toList();
    }

    @Override
    public EquipementDTO getEquipementById(Long id) {
        return equipementRepository.findById(id).map(equipementMapper::entityToDto)
                .orElseThrow(() -> new ApiException("Equipement not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public EquipementDTO createEquipement(CreateEquipementDTO equipement) {
        return equipementMapper.entityToDto(equipementRepository.save(equipementMapper.requestToEntity(equipement)));
    }

    @Override
    public EquipementDTO updateEquipement(CreateEquipementDTO equipement, Long id) {
        return equipementRepository.findById(id)
                .map(existingEquipement -> {
                    Equipement updatedEquipement = equipementMapper.requestToEntity(equipement);
                    updatedEquipement.setId(existingEquipement.getId());
                    Equipement savedEquipement = equipementRepository.save(updatedEquipement);
                    return equipementMapper.entityToDto(savedEquipement);
                })
                .orElseThrow(() -> new ApiException("Equipement not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public EquipementDTO deleteEquipement(Long id) {
        Equipement equipement = equipementRepository.findById(id).orElseThrow(() -> new ApiException("Equipement not found", HttpStatus.NOT_FOUND));
        equipementRepository.delete(equipement);
        return equipementMapper.entityToDto(equipement);
    }
    
}
