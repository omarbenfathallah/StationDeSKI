package com.example.ski.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkiteur;
    private String NomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Piste> pistes;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "skiteurs")
    Set<Inscription> inscriptions;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Abonnement abonnement;


}
