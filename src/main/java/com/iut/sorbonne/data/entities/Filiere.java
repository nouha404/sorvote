package com.iut.sorbonne.data.entities;

import com.iut.sorbonne.data.enums.EFiliere;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "filieres")
public class Filiere extends AbstractEntity{
    @Enumerated(value = EnumType.STRING)
    private EFiliere libelle;

    @OneToMany(mappedBy = "filiere")
    private List<Classe> classes;
}
