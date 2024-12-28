package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.Candidat;
import com.iut.sorbonne.data.entities.SessionVote;
import com.iut.sorbonne.data.entities.Tendance;
import com.iut.sorbonne.data.repositories.CandidatRepository;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import com.iut.sorbonne.data.repositories.TendanceRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@RequiredArgsConstructor
@Component
@Transactional
@Order(11)
public class TendanceFixtures implements CommandLineRunner {
    private final TendanceRepository tendanceRepository;
    private final SessionVoteRepository sessionVoteRepository;
    private final CandidatRepository candidatRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("fr"));
        List<Candidat> candidatList = candidatRepository.findAll();
        List<SessionVote> sessionVotes = sessionVoteRepository.findAll();

        if (!sessionVotes.isEmpty() && !candidatList.isEmpty()) {
            for (SessionVote sessionVote : sessionVotes) {
                // Créer une tendance pour chaque session de vote
                Tendance tendance = new Tendance();
                tendance.setSessionVote(sessionVote);

                // Sauvegarder la tendance seule avant d'ajouter les candidats
                tendance = tendanceRepository.save(tendance);

                // Sélectionner un nombre aléatoire de candidats (entre 2 et 6)
                int nbCandidats = faker.number().numberBetween(2, 6);
                List<Candidat> candidatsAssocies = new ArrayList<>();
                for (int i = 0; i < nbCandidats; i++) {
                    Candidat candidat = candidatList.get(faker.number().numberBetween(0, candidatList.size()));
                    if (!candidatsAssocies.contains(candidat)) {
                        candidat.setTendance(tendance); // Associer la tendance
                        candidatsAssocies.add(candidat);
                    }
                }

                // Sauvegarder les candidats avec la tendance mise à jour
                candidatRepository.saveAll(candidatsAssocies);

                // Associer les candidats à la tendance
                tendance.setCandidats(candidatsAssocies);

                // Sauvegarder la tendance avec les candidats (optionnel, car Hibernate gère déjà la relation)
                tendanceRepository.save(tendance);
            }
        } else {
            System.out.println("Aucune session de vote ou aucun candidat trouvé.");
        }
    }
}
