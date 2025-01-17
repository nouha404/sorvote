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
    private Long nombreDeVote;

    @ManyToOne
    private Tendance tendance;

    @OneToOne
    private DocumentFile document;
    @OneToOne
    AudioFile audio;


}
