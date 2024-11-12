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
@Table(name = "audios")
public class Audio extends AbstractEntity {
    private String libelle;
    private String format;
    private String path;
    private String size;

    @OneToOne
    private Candidat candidat;
}
