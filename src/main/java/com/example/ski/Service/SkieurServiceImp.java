package com.example.ski.Service;

import com.example.ski.Entity.Abonnement;
import com.example.ski.Entity.Inscription;
import com.example.ski.Entity.Piste;
import com.example.ski.Entity.Skieur;
import com.example.ski.Repository.InscriptionRepository;
import com.example.ski.Repository.PisteRepository;
import com.example.ski.Repository.SkieurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
