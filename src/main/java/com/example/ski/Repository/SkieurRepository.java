package com.example.ski.Repository;

import com.example.ski.Entity.Skieur;
import com.example.ski.Entity.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;
import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {
    Skieur getSkieurByNumSkiteur(Long num);

    List<Skieur> getSkieurByAbonnement_TypeAbon(TypeAbonnement typeAbonnement);

}
