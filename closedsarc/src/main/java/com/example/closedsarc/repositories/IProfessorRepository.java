package com.example.closedsarc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.closedsarc.models.Professor;

public interface IProfessorRepository extends JpaRepository<Professor, Long> {
}
