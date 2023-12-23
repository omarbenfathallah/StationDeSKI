package com.example.ski.Controller;

import com.example.ski.Entity.Abonnement;
import com.example.ski.Entity.TypeAbonnement;
import com.example.ski.Service.IInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
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
    @GetMapping("/byDates")
    public ResponseEntity<List<Abonnement>> getAbonnementsByDates(
            @RequestParam("startDate")  LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<Abonnement> abonnements = iInscriptionService.retrieveSubscriptionsByDates(startDate, endDate);

        // You can add additional logic, error handling, or response customization here
        return ResponseEntity.ok(abonnements);
    }
}
