package com.example.ski.Repository;

import com.example.ski.Entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
}
