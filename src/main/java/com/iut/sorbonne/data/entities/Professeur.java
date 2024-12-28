package com.iut.sorbonne.data.entities;

import com.iut.sorbonne.data.enums.ESpecialite;
import jakarta.persistence.*;
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
    @Enumerated(value = EnumType.STRING)
    private ESpecialite ESpecialite;
    @OneToMany(mappedBy = "professeur")
    private List<SessionVote> sessionVotes;
}
