package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.SessionVote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionVoteRepository extends JpaRepository<SessionVote, Long> {
    Page<SessionVote> findAllByIsActiveTrue(Pageable page);
    List<SessionVote> findAllByIsActiveTrue(); //for tester data
    // Page<Cours> findByProfesseur(Professeur professeur, Pageable pageable);
}
