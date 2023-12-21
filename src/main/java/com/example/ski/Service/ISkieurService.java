package com.example.ski.Service;

import com.example.ski.Entity.Inscription;
import com.example.ski.Entity.Skieur;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
    Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier);

}
