package com.example.ski.Service;

import com.example.ski.Entity.Abonnement;
import com.example.ski.Entity.Inscription;
import com.example.ski.Entity.TypeAbonnement;

import java.util.Set;

public interface IInscriptionService {
    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);
    Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbon);
}
