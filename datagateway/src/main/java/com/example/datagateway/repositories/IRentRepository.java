package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.models.Rent;

public interface IRentRepository extends JpaRepository<Rent, Long> {
}
