package com.iut.sorbonne.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @OneToMany(mappedBy = "etatSessionVote")
    private List<SessionVote> sessionVotes;

}
