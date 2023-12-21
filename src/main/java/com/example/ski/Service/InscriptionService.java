package com.example.ski.Service;

import com.example.ski.Entity.Cours;
import com.example.ski.Entity.Inscription;
import com.example.ski.Repository.CoursRepository;
import com.example.ski.Repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscriptionService implements IInscriptionService{

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Autowired
    CoursRepository coursRepository;

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = inscriptionRepository.getReferenceById(numRegistration);
        Cours cours = coursRepository.getReferenceById(numCourse);

        inscription.setCours(cours);

        // Save both entities
        inscriptionRepository.save(inscription);
        coursRepository.save(cours);

        return inscription;
    }
}
