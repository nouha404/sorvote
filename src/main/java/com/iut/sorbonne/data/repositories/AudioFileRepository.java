package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.AudioFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioFileRepository extends JpaRepository<AudioFile,Long> {
}
