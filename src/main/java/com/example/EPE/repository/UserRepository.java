package com.example.EPE.repository;

import com.example.EPE.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByEmail(String email);

    // FR-6 : As team lead or buddy see users assigned to me
    List<User> findUsersByBuddyIdOrTeamLeaderId(UUID id1, UUID id2);

}