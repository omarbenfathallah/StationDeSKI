package com.example.ski.Service;

import com.example.ski.Entity.Abonnement;
import com.example.ski.Entity.Cours;
import com.example.ski.Entity.Inscription;
import com.example.ski.Entity.TypeAbonnement;
import com.example.ski.Repository.AbonnementRepository;
import com.example.ski.Repository.CoursRepository;
import com.example.ski.Repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class InscriptionService implements IInscriptionService{

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    CoursRepository coursRepository;
    @Autowired
    AbonnementRepository abonnementRepository;

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
        return abonnementRepository.getAbonnementsByDateDebuBetween(startDate,endDate);
    }
}
