package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "etudiants")
public class Etudiant extends AbstractEntity {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
    private Boolean isVoted;

    @ManyToOne
    private SessionVote sessionVote;
    @ManyToOne
    private Classe classe;

}
