package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentFileRepository extends JpaRepository<DocumentFile, Long> {
}
