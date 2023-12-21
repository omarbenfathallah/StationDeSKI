package com.example.ski.Repository;

import com.example.ski.Entity.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {
    Skieur getSkieurByNumSkiteur(Long num);

}
