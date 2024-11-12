package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Tendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TendanceRepository extends JpaRepository<Tendance, Long> {
}
