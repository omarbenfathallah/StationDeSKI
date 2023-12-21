package com.example.ski.Service;

import com.example.ski.Entity.Cours;
import com.example.ski.Repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoursServiceImp implements ICoursService{


    @Autowired
    CoursRepository coursRepository;


    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    //Jpql
    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.getReferenceById(numCours);
    }


}
