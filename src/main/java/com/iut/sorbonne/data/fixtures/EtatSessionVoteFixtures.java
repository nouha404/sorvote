package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.EtatSessionVote;
import com.iut.sorbonne.data.repositories.EtatSessionVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
//@Component
@Order(4)
public class EtatSessionVoteFixtures implements CommandLineRunner {
    private final EtatSessionVoteRepository etatSessionVoteRepository;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i<=10; i++) {
            EtatSessionVote etatSessionVote = new EtatSessionVote();
            etatSessionVote.setIsActive(true);
            etatSessionVote.setLibelle(i%2==0? "Encours": "Terminer");
            etatSessionVoteRepository.save(etatSessionVote);
        }

    }
}
