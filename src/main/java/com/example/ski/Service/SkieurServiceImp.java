package com.example.ski.Service;

import com.example.ski.Entity.Inscription;
import com.example.ski.Entity.Skieur;
import com.example.ski.Repository.InscriptionRepository;
import com.example.ski.Repository.SkieurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SkieurServiceImp implements ISkieurService{

    @Autowired
    SkieurRepository skieurRepository;

    @Autowired
    InscriptionRepository inscriptionRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        switch(skieur.getAbonnement().getTypeAbon()){
            case ANNUEL : skieur.getAbonnement().setDateFin(skieur.getAbonnement().getDateDebu().plusYears(1));
            break;
            case MENSUEL:skieur.getAbonnement().setDateFin(skieur.getAbonnement().getDateDebu().plusMonths(1));
            break;
            case SEMESTRIEL:skieur.getAbonnement().setDateFin(skieur.getAbonnement().getDateDebu().plusMonths(6));
            break;
        }
        return  skieurRepository.save(skieur);
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
}
