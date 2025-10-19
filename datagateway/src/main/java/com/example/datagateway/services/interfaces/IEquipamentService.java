package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.models.Equipament;

public interface IEquipamentService {
    List<Equipament> getAllEquipaments();
    Equipament getEquipamentById(Long id);
    Equipament createEquipament(Equipament equipament);
    Equipament updateEquipament(Equipament equipament);
    Equipament deleteEquipament(Long id);
}
