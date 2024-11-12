package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Tendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TendanceRepository extends JpaRepository<Tendance, Long> {
}
