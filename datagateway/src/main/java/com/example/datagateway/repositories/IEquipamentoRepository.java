package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.common.models.Equipamento;

public interface IEquipamentoRepository extends JpaRepository<Equipamento, Long> {
}