package com.example.apigateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apigateway.models.Turma;

public interface ITurmaRepository extends JpaRepository<Turma, Long> {
}
