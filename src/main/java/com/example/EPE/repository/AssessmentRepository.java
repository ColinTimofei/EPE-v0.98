package com.example.EPE.repository;

import com.example.EPE.entity.Assessment;
import com.example.EPE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AssessmentRepository extends JpaRepository<Assessment, UUID> {

    List<Assessment> findAllByUser(User user);

}
