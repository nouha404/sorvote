package com.iut.sorbonne.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
@Table(name = "classes")
public class Classe extends AbstractEntity {
    private String libelle;

    @ManyToOne
    private Niveau niveau;
    @ManyToOne
    private Filiere filiere;
    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

}
