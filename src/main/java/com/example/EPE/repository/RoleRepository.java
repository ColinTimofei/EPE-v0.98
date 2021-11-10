package com.example.EPE.repository;

import com.example.EPE.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Roles findByRole(String name);

}
