package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.common.models.ItemLocavel;

public interface IItemLocavelRepository extends JpaRepository<ItemLocavel, Long> {
}
