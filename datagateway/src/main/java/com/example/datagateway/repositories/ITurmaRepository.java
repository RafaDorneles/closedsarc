package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.common.models.Turma;

public interface ITurmaRepository extends JpaRepository<Turma, Long> {
}
