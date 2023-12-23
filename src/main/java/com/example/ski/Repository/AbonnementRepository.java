package com.example.ski.Repository;

import com.example.ski.Entity.Abonnement;
import com.example.ski.Entity.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {

    Set<Abonnement> getAbonnementsByTypeAbonOrderByDateDebu(TypeAbonnement typeAbonnement);

    List<Abonnement> getAbonnementsByDateDebuBetween(LocalDate datedebu, LocalDate datefin );
}
