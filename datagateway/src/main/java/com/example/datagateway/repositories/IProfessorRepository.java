package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.common.models.Professor;

public interface IProfessorRepository extends JpaRepository<Professor, Long> {
}
