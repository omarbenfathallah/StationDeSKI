package com.example.ski.Controller;

import com.example.ski.Entity.Cours;
import com.example.ski.Entity.Moniteur;
import com.example.ski.Service.ICoursService;
import com.example.ski.Service.IMoniteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Moniteur")
public class MoniteurController {
    @Autowired
    IMoniteurService iMoniteurService;

    @GetMapping("/allMoniteurs")
    public List<Moniteur> getAllMoniteur(){
        return iMoniteurService.retrieveAllMoniteurs();
    }
    @PutMapping("/update")
    public Moniteur updateMoniteurs(@RequestBody Moniteur moniteur){
        return  iMoniteurService.updateMoniteur(moniteur);
    }
    @PostMapping("/add")
    public Moniteur createMoniteur(@RequestBody Moniteur moniteur){
        return iMoniteurService.addMoniteur(moniteur);
    }
    @DeleteMapping("/MoniteursById/{id}")
    public Moniteur getMoniteursById(@PathVariable Long id){
        return iMoniteurService.retrieveMoniteur(id);
    }

    @PostMapping("/addMoniteurAvecCours/{numCours}")
    public Moniteur createMoniteur(@RequestBody Moniteur moniteur,@PathVariable Long numCours){
        return iMoniteurService.addInstructorAndAssignToCourse(moniteur,numCours);
    }
}
