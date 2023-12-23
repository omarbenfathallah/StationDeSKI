package com.example.ski.Service;

import com.example.ski.Entity.Cours;
import com.example.ski.Entity.Moniteur;
import com.example.ski.Entity.Support;
import com.example.ski.Repository.CoursRepository;
import com.example.ski.Repository.MoniteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MoniteurServiceImp implements IMoniteurService{

    @Autowired
    MoniteurRepository moniteurRepository;
    @Autowired
    CoursRepository coursRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.getReferenceById(numMoniteur);
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElse(null);

        Set<Cours> setCours = new HashSet<>();
        setCours.add(cours);
        moniteur.setCours(setCours);

        return moniteurRepository.save(moniteur);

    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        return moniteurRepository.numWeeksCourseOfInstructorBySupport(numInstructor,support);
    }
}
