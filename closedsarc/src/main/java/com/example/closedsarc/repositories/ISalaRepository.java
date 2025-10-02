package com.example.closedsarc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.closedsarc.models.Sala;

public interface ISalaRepository extends JpaRepository<Sala, Long> {
}
