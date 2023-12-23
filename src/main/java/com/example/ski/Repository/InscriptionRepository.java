package com.example.ski.Repository;

import com.example.ski.Entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription,Long> {
    Inscription findInscriptionByCours_NumCours(Long numcours);



}
