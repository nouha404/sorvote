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
public class DocumentFile extends AbstractEntity{
    private String libelle;
    private String typeDocument;
    private long size;
    private String uri;

    @OneToOne(mappedBy = "document")
    private Candidat candidat;

}
