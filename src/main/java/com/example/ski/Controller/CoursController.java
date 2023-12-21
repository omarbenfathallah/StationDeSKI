package com.example.ski.Controller;

import com.example.ski.Entity.Cours;
import com.example.ski.Service.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cours")
public class CoursController {
    @Autowired
    ICoursService iCoursService;

    @GetMapping("/allCours")
    public List<Cours> getAllCours(){
        return iCoursService.retrieveAllCourses();
    }
    @PutMapping("/update")
    public Cours updateCours(@RequestBody  Cours cours){
        return  iCoursService.updateCours(cours);
    }
    @PostMapping("/add")
    public Cours createCours(@RequestBody Cours cours){
        return iCoursService.addCours(cours);
    }
    @DeleteMapping("/CoursById/{id}")
    public Cours getCoursById(@PathVariable Long id){
       return iCoursService.retrieveCours(id);
    }

}
