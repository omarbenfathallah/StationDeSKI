package com.example.ski.Repository;

import com.example.ski.Entity.Abonnement;
import com.example.ski.Entity.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {

    Set<Abonnement> getAbonnementsByTypeAbonOrderByDateDebu(TypeAbonnement typeAbonnement);
}
