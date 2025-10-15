package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.models.Sala;

public interface ISalaRepository extends JpaRepository<Sala, Long> {
}
