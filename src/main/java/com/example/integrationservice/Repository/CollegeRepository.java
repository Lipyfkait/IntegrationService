package com.example.integrationservice.Repository;

import com.example.integrationservice.Entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
}
