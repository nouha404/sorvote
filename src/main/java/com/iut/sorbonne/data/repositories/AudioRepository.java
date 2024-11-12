package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, Long> {
}
