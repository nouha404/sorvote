package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
}
