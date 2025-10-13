package com.example.apigateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apigateway.models.Sala;

public interface ISalaRepository extends JpaRepository<Sala, Long> {
}
