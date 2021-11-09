package com.example.EPE.repository;

import com.example.EPE.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {

    Optional<Image> findById(UUID id);

}
