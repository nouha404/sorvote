package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.Candidat;
import com.iut.sorbonne.data.repositories.AudioRepository;
import com.iut.sorbonne.data.repositories.CandidatRepository;
import com.iut.sorbonne.data.repositories.DocumentRepository;
import com.iut.sorbonne.data.repositories.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(11)
public class CandidatFixtures implements CommandLineRunner {
    private final CandidatRepository candidatRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public void run(String... args) throws Exception {
        for (long i=1;i<=5L;i++) {
            Candidat candidat = new Candidat();
            candidat.setNombreDeVote(etudiantRepository.findAll().size()/i);
            candidat.setDocument(null);
            candidat.setAudio(null);
            candidat.setTendance(null);
            candidatRepository.save(candidat);

        }

    }
}
