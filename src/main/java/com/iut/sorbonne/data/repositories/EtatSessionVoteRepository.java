package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.EtatSessionVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatSessionVoteRepository extends JpaRepository<EtatSessionVote, Long>  {
}
