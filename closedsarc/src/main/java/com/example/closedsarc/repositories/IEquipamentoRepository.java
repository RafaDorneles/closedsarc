package com.example.closedsarc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.closedsarc.models.Equipamento;

public interface IEquipamentoRepository extends JpaRepository<Equipamento, Long> {
}