package com.example.ski.Service;

import com.example.ski.Entity.Moniteur;
import com.example.ski.Entity.Support;

import java.util.List;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);



}
