package com.example.ski.Service;

import com.example.ski.Entity.Inscription;
import com.example.ski.Entity.Skieur;
import com.example.ski.Entity.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
    Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);
    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);

    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);



}
