package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "tendances")
public class Tendance extends AbstractEntity {
    @OneToMany(mappedBy = "tendance")
    private List<Candidat> candidats;
    @OneToOne
    private SessionVote sessionVote;

}
