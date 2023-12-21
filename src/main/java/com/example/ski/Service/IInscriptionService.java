package com.example.ski.Service;

import com.example.ski.Entity.Inscription;

public interface IInscriptionService {
    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);

}
