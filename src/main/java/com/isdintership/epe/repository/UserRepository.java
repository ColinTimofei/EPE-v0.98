package com.isdintership.epe.repository;

import com.isdintership.epe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByFirstname(String name);
    User findByEmail(String email);
}
