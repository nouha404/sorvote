package com.iut.sorbonne.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AudioFile extends AbstractEntity {
    private String libelle;
    private String format;
    private long duration;
    private String uri;

    @OneToOne(mappedBy = "audio")
    private Candidat candidat;
}
