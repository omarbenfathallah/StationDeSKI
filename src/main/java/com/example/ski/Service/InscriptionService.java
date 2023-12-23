package com.example.ski.Service;

import com.example.ski.Entity.*;
import com.example.ski.Repository.AbonnementRepository;
import com.example.ski.Repository.CoursRepository;
import com.example.ski.Repository.InscriptionRepository;
import com.example.ski.Repository.SkieurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class InscriptionService implements IInscriptionService {

    @Autowired
    InscriptionRepository inscriptionRepository;
    @Autowired
    CoursRepository coursRepository;
    @Autowired
    AbonnementRepository abonnementRepository;
    @Autowired
    SkieurRepository skieurRepository;


    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = inscriptionRepository.getReferenceById(numRegistration);
        Cours cours = coursRepository.getReferenceById(numCourse);

        inscription.setCours(cours);

        Inscription savedInscription = inscriptionRepository.save(inscription);

        cours.getInscriptions().add(savedInscription);
        coursRepository.save(cours);

        return inscription;
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement typeAbon) {
        return abonnementRepository.getAbonnementsByTypeAbonOrderByDateDebu(typeAbon);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.getAbonnementsByDateDebuBetween(startDate, endDate);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Cours cours = coursRepository.findById(numCours).orElse(null);
        // Check if the course type is COLLECTIF_ENFANT or COLLECTIF_ADULTE
        if (cours.getTypeCours() == TypeCours.COLLECTIF_ADULT || cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT) {
            //check if the number of the registrations  for the cours is less than 6
            if (cours.getInscriptions().size() >= 6) {

            }

        }
        return null;
    }

    @Scheduled(cron = "0 0/30 * * * ?") // Run every 30 minutes
    @Override
    public void retrieveSubscriptions() {
        for (Abonnement sub : abonnementRepository.findDistinctOrderByEndDateAsc()) {
            Skieur aSkier = skieurRepository.findByAbonnement(sub);
            System.out.println(sub.getNumAbon().toString() + " | " + sub.getDateFin().toString()
                    + " | " + aSkier.getPrenomS() + " " + aSkier.getNomS());
        }
    }
}