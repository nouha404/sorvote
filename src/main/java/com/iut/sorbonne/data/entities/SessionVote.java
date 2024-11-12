package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "SessionVotes")
public class SessionVote extends  AbstractEntity {
    @ManyToOne
    private EtatSessionVote etatSessionVote;
    @ManyToOne
    private Professeur professeur;
    @OneToOne
    private Tendance tendance;
    @OneToMany(mappedBy = "sessionVote")
    private List<Etudiant> etudiants;

    @OneToOne(mappedBy = "sessionVote", cascade = CascadeType.ALL,orphanRemoval = true)
    private DateSession dateSession;


}
