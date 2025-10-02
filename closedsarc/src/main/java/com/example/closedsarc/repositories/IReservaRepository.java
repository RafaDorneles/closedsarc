package com.example.closedsarc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.closedsarc.models.Reserva;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {
}
