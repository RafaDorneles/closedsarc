package com.example.apigateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apigateway.models.Professor;

public interface IProfessorRepository extends JpaRepository<Professor, Long> {
}
