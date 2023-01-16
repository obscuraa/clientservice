package com.example.clientservice.repository;

import com.example.clientservice.model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, UUID> {
    Optional<Shoes> findByClientId(UUID clientId);
}
