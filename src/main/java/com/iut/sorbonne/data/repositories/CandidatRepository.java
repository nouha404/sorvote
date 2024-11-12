package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
}
