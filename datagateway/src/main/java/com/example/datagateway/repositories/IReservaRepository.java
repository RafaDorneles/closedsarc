package com.example.apigateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.common.models.Reserva;

public interface IReservaRepository extends JpaRepository<Reserva, Long> {
}
