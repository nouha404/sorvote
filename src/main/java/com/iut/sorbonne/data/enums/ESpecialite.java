package com.iut.sorbonne.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ESpecialite {
    // Sciences exactes
    MATHEMATIQUES,
    PHYSIQUE,
    CHIMIE,
    INFORMATIQUE,
    ELECTRONIQUE,
    GENIE_CIVIL,

    // Sciences humaines et sociales
    LITTERATURE,
    PHILOSOPHIE,
    HISTOIRE,
    SOCIOLOGIE,
    PSYCHOLOGIE,
    ANTHROPOLOGIE,
    GEOGRAPHIE,

    // Sciences économiques et de gestion
    ECONOMIE,
    GESTION,
    COMPTABILITE,
    MARKETING,

    // Santé et biologie
    BIOLOGIE,
    BIOCHIMIE,
    MEDECINE,
    SCIENCES_PHARMACEUTIQUES,
    SCIENCES_INFERMIERES,

    // Arts et communication
    CINEMA,
    ARTS_PLASTIQUES,
    COMMUNICATION,
    JOURNALISME,

    // Langues et cultures
    ANGLAIS,
    ESPAGNOL,
    ALLEMAND,
    JAPONAIS,
    ITALIEN,

    // Activités sportives
    SPORT,
    EDUCATION_PHYSIQUE,
    KINESITHERAPIE,
    ENTRAINEUR_SPORTIF
}
