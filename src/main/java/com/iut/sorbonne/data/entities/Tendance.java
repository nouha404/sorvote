package com.iut.sorbonne.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tendances")
public class Tendance extends AbstractEntity {
    @Transient
    private SessionVote sessionVote; //  sessionVote ne sera pas enregistrée dans la table tendances lors d'un save de Tendance il est juste la pour des calculs ou des associations temporaires
    @OneToMany(mappedBy = "tendance")
    private List<Candidat> candidats;

}
