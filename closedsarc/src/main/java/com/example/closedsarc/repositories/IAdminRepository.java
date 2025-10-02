package com.example.closedsarc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.closedsarc.models.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long> {
}
