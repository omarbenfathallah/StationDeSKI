package com.example.ski.Service;

import com.example.ski.Entity.*;
import com.example.ski.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SkieurServiceImp implements ISkieurService{

    @Autowired
    SkieurRepository skieurRepository;

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    PisteRepository pisteRepository;

    @Autowired
    CoursRepository coursRepository;
    @Autowired
    AbonnementRepository abonnementRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        Abonnement abonnement = skieur.getAbonnement();

        if (abonnement != null) {
            switch (abonnement.getTypeAbon()) {
                case ANNUEL:
                    abonnement.setDateFin(abonnement.getDateDebu().plusYears(1));
                    break;
                case MENSUEL:
                    abonnement.setDateFin(abonnement.getDateDebu().plusMonths(1));
                    break;
                case SEMESTRIEL:
                    abonnement.setDateFin(abonnement.getDateDebu().plusMonths(6));
                    break;
            }
        }

        // Set the skieur for the abonnement
        if (skieur.getAbonnement() != null) {
            skieur.getAbonnement().setTypeAbon(skieur.getAbonnement().getTypeAbon());
        }

        // Save both skieur and abonnement
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.getSkieurByNumSkiteur(numSkieur);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier) {
        Skieur skieur = skieurRepository.getSkieurByNumSkiteur(numSkier);

        inscription.setSkiteurs(skieur);

        return inscriptionRepository.save(inscription);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null);
        Piste piste =pisteRepository.findById(numPiste).orElse(null);

        skieur.getPistes().add(piste);


        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        //Skieur savedSkieur = skieurRepository.save(skieur);
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        // Create and set abonnement for the skieur
        Abonnement abonnement = new Abonnement();
        abonnement.setDateFin(skieur.getAbonnement().getDateFin());
        abonnement.setDateDebu(skieur.getAbonnement().getDateDebu());

        // Set abonnement for the skieur
        skieur.setAbonnement(abonnement);

        // Create and set inscription for the skieur
        Inscription inscription = new Inscription();
        // Set inscription properties as needed
        // ...

        // Set skieur and course for the inscription
        inscription.setSkiteurs(skieur);
        inscription.setCours(cours);

        // Save abonnement, skieur, and inscription entities
        abonnementRepository.save(abonnement);
        Skieur savedSkieur = skieurRepository.save(skieur);
        Inscription savedInscription = inscriptionRepository.save(inscription);

        // Assign the skieur and inscription to the course
        cours.getInscriptions().add(savedInscription);
        coursRepository.save(cours);

        // Update the skieur with the saved inscription
        savedSkieur.getInscriptions().add(savedInscription);
        skieurRepository.save(savedSkieur);

        return savedSkieur;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.getSkieurByAbonnement_TypeAbon(typeAbonnement);
    }

}
