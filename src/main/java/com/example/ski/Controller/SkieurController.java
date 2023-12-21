package com.example.ski.Controller;

import com.example.ski.Entity.Inscription;
import com.example.ski.Entity.Piste;
import com.example.ski.Entity.Skieur;
import com.example.ski.Service.ICoursService;
import com.example.ski.Service.ISkieurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Skieur")
public class SkieurController {
    @Autowired
    ISkieurService  iSkieurService;

    @GetMapping("/allSkieurs")
    public List<Skieur> retrieveAllPistes(){
        return iSkieurService.retrieveAllSkieurs();
    }
    @PostMapping("/add")
    public Skieur createMoniteur(@RequestBody Skieur Skieur){
        return iSkieurService.addSkieur(Skieur);
    }
    @DeleteMapping("/SkieursById/{id}")
    void getCoursById(@PathVariable Long id){
         iSkieurService.removeSkieur(id);
    }

    @GetMapping("/{d}")
    public Skieur retrievePiste(@PathVariable Long id){
        return iSkieurService.retrieveSkieur(id);
    }

    @PostMapping("/Inscription/{id}")
    public Inscription ajouterInscriotion(@PathVariable Long id , @RequestBody Inscription inscription){
        return iSkieurService.addRegistrationAndAssignToSkier(inscription,id);
    }
}
