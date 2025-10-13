package com.example.apigateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apigateway.models.Equipamento;

public interface IEquipamentoRepository extends JpaRepository<Equipamento, Long> {
}