package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "candidats")
public class Candidat extends Etudiant {
    private long nombreDeVote;

    private String documentLibelle;
    private String documentFormat;
    private String documentPath;
    private Long documentSize;

    private String audioLibelle;
    private String audioFormat;
    private String audioPath;
    private Long audioSize;

    @ManyToOne
    private Tendance tendance;

}
