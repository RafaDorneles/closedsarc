package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.models.Equipement;

public interface IEquipementRepository extends JpaRepository<Equipement, Long> {
}