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
@Table(name = "classes")
public class Classe extends AbstractEntity {
    private String libelle;

    @ManyToOne
    private Niveau niveau;
    @ManyToOne
    private Filiere filiere;
    @OneToMany(mappedBy = "classe",cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

}
