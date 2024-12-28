package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.entities.EtatSessionVote;
import com.iut.sorbonne.data.repositories.EtatSessionVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(1)
public class EtatSessionVoteFixtures implements CommandLineRunner {
    private final EtatSessionVoteRepository etatSessionVoteRepository;
    @Override
    public void run(String... args) throws Exception {
        EtatSessionVote enCours = new EtatSessionVote();
        enCours.setIsActive(true);
        enCours.setLibelle("En cours");
        etatSessionVoteRepository.save(enCours);

        EtatSessionVote termine = new EtatSessionVote();
        termine.setIsActive(false);
        termine.setLibelle("Terminé");
        etatSessionVoteRepository.save(termine);

    }

 }
