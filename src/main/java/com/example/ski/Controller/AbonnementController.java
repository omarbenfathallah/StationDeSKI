package com.example.ski.Controller;

import com.example.ski.Entity.Abonnement;
import com.example.ski.Entity.TypeAbonnement;
import com.example.ski.Service.IInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/Abonnement")
public class AbonnementController {
    @Autowired
    IInscriptionService iInscriptionService;
    @GetMapping("/ByType/{typeAbon}")
    public Set<Abonnement> getAbonByType(@PathVariable("typeAbon")TypeAbonnement typeAbon){
        return iInscriptionService.getSubscriptionByType(typeAbon);
    }
}
