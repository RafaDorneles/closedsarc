package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.common.models.Class;

public interface ITurmaRepository extends JpaRepository<Class, Long> {
}
