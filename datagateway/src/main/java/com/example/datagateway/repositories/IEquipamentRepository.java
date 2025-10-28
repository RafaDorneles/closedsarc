package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.models.Equipament;

public interface IEquipamentRepository extends JpaRepository<Equipament, Long> {
}