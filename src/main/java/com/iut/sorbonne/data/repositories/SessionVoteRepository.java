package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.SessionVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionVoteRepository extends JpaRepository<SessionVote, Long> {
}
