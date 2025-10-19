package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.models.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {
}
