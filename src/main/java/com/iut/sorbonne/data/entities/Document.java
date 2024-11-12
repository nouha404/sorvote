package com.iut.sorbonne.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "documents")
public class Document extends AbstractEntity {
    private String libelle;
    private String format;
    private Long size;
    private String path;

    @OneToOne
    private Candidat candidat;
}
