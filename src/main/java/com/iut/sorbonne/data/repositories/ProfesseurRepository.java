package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}
