package com.example.apigateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.models.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long> {
}
