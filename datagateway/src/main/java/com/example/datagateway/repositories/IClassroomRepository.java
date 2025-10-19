package com.example.datagateway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.common.models.Classroom;

public interface IClassroomRepository extends JpaRepository<Classroom, Long> {
}
