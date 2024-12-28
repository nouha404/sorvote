package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "EtatSessionVotes")
public class EtatSessionVote extends AbstractEntity {
    private String libelle;
    @OneToMany(mappedBy = "etatSessionVote",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SessionVote> sessionVotes;

}
