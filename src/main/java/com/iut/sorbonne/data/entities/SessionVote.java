package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "SessionVotes")
public class SessionVote extends  AbstractEntity {
    @DateTimeFormat(pattern = "EEEE dd MMMM yyyy")
    private LocalDate dateDebut;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heureDebut;
    @DateTimeFormat(pattern = "EEEE dd MMMM yyyy")
    private LocalDate dateFin;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime heureFin;

    @ManyToOne
    private EtatSessionVote etatSessionVote;
    @ManyToOne
    private Professeur professeur;
    @OneToOne(mappedBy = "sessionVote", cascade = CascadeType.ALL)
    private Tendance tendance;
    @OneToMany(mappedBy = "sessionVote")
    private List<Etudiant> etudiants;



}
