package com.isdintership.epe.repository;

import com.isdintership.epe.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String name);

}
