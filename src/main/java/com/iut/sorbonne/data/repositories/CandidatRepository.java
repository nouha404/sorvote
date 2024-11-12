package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
}
