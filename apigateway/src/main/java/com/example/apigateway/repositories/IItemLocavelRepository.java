package com.example.apigateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apigateway.models.ItemLocavel;

public interface IItemLocavelRepository extends JpaRepository<ItemLocavel, Long> {
}
