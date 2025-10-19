package com.example.datagateway.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.common.exceptions.ApiException;
import com.example.common.models.Equipamento;
import com.example.datagateway.repositories.IEquipamentoRepository;
import com.example.datagateway.services.interfaces.IEquipamentoService;

public class EquipamentoService implements IEquipamentoService {

    @Autowired
    private IEquipamentoRepository equipamentoRepository;

    @Override
    public List<Equipamento> getAllEquipamentos() {
        return equipamentoRepository.findAll();
    }

    @Override
    public Equipamento getEquipamentoById(Long id) {
        return equipamentoRepository.findById(id).orElseThrow(() -> new ApiException("Equipament not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public Equipamento createEquipamento(Equipamento equipamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Equipamento updateEquipamento(Equipamento equipamento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Equipamento deleteEquipamento(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
