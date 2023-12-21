package com.example.ski.Controller;

import com.example.ski.Entity.Inscription;
import com.example.ski.Service.IInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Inscription")
public class InscriptionController {
    @Autowired
    private IInscriptionService iInscriptionService;

    @PostMapping("/AddInscriptionToCourse/{numIns}/{numCours}")
    public Inscription  assignRegistrationToCourse(@PathVariable Long numIns ,@PathVariable Long numCours){
        return  iInscriptionService.assignRegistrationToCourse(numIns,numCours);
    }
}
