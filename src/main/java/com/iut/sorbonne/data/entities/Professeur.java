package com.iut.sorbonne.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "professeurs")
public class Professeur extends AbstractEntity {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;

    @OneToMany(mappedBy = "professeur")
    private List<SessionVote> sessionVotes;
}
