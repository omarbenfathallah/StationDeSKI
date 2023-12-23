package com.example.ski.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInscription;
    private int numSemaine;

    @ManyToOne
    @JsonIgnore
    private Skieur skiteurs;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cours_num_cours")
    private Cours cours;

}
