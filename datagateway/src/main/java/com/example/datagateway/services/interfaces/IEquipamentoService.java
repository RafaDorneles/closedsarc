package com.example.datagateway.services.interfaces;

import java.util.List;

import com.example.common.models.Equipamento;

public interface IEquipamentoService {
    List<Equipamento> getAllEquipamentos();
    Equipamento getEquipamentoById(Long id);
    Equipamento createEquipamento(Equipamento equipamento);
    Equipamento updateEquipamento(Equipamento equipamento);
    Equipamento deleteEquipamento(Long id);
}
