package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.common.exceptions.ApiException;
import com.example.common.models.Equipament;
import com.example.datagateway.repositories.IEquipamentRepository;
import com.example.datagateway.services.interfaces.IEquipamentService;

@Service
public class EquipamentService implements IEquipamentService {

    @Autowired
    private IEquipamentRepository equipamentRepository;

    @Override
    public List<Equipament> getAllEquipaments() {
        return equipamentRepository.findAll();
    }

    @Override
    public Equipament getEquipamentById(Long id) {
        return equipamentRepository.findById(id).orElseThrow(() -> new ApiException("Equipament not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Equipament createEquipament(Equipament equipament) {
        return equipamentRepository.save(equipament);
    }

    @Override
    public Equipament updateEquipament(Equipament equipament) {
        return equipamentRepository.save(equipament);
    }

    @Override
    public Equipament deleteEquipament(Long id) {
        Equipament equipament = equipamentRepository.findById(id).orElseThrow(() -> new ApiException("Equipament not found", HttpStatus.NOT_FOUND));
        equipamentRepository.delete(equipament);
        return equipament;
    }
    
}
