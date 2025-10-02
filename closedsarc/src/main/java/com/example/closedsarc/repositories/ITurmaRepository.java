package com.example.closedsarc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.closedsarc.models.Turma;

public interface ITurmaRepository extends JpaRepository<Turma, Long> {
}
