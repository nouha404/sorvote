package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
