package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.SessionVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionVoteRepository extends JpaRepository<SessionVote, Long> {
}
