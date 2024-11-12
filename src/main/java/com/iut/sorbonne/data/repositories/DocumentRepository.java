package com.iut.sorbonne.data.repositories;

import com.iut.sorbonne.data.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
