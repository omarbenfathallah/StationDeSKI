package com.example.ski.Service;

import com.example.ski.Entity.Abonnement;
import com.example.ski.Entity.Inscription;
import com.example.ski.Entity.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IInscriptionService {
    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbon);

    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate,LocalDate endDate);

    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription,Long numSkieur, Long numCours);

}
