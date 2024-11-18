package com.iut.sorbonne.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "EtatSessionVotes")
public class EtatSessionVote extends AbstractEntity {
    private String libelle;
    @OneToMany(mappedBy = "etatSessionVote",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SessionVote> sessionVotes;

    @Override
    public String toString() {
        return "EtatSessionVote{" +
                "libelle='" + libelle + '\'' +
                ", isActive=" + getIsActive() +
                '}';
    }

}
