package com.example.ski.Controller;

import com.example.ski.Entity.Moniteur;
import com.example.ski.Entity.Piste;
import com.example.ski.Service.IPisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Piste")
public class PisteController {
    @Autowired
    IPisteService iPisteService;

    @GetMapping("/allMoniteurs")
    public List<Piste> retrieveAllPistes(){
        return iPisteService.retrieveAllPistes();
    }
    @PutMapping("/update")
    public Piste updatePistes(@RequestBody Piste piste){
        return  iPisteService.updatePiste(piste);
    }
    @PostMapping("/add")
    public Piste createPiste(@RequestBody Piste piste){
        return iPisteService.addPiste(piste);
    }
    @DeleteMapping("/PistesById/{id}")
    public Piste getPisteById(@PathVariable Long id){
        return iPisteService.retrievePiste(id);
    }

}
