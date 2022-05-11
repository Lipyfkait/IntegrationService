package com.example.integrationservice.Repository;

import com.example.integrationservice.Entity.ExamUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamUser, Long> {

}
