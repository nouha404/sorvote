package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tendances")
public class Tendance extends AbstractEntity {
    @OneToOne
    private SessionVote sessionVote; //  sessionVote ne sera pas enregistrée dans la table tendances lors d'un save de Tendance il est juste la pour des calculs ou des associations temporaires
    @OneToMany(mappedBy = "tendance")
    private List<Candidat> candidats;

}
