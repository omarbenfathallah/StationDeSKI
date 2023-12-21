package com.example.ski.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private  String nomPiste;
    private int longeur;
    private int pente;
    @Enumerated(EnumType.STRING)
    private Couleur couleur;

    @ManyToMany(cascade =CascadeType.ALL,mappedBy = "pistes")
    Set<Skiteur> skiteurs;
}
