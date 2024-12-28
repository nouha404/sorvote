package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.*;
import com.iut.sorbonne.data.repositories.EtatSessionVoteRepository;
import com.iut.sorbonne.data.repositories.ProfesseurRepository;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Component
@Order(7)
public class SessionVoteFixtures implements CommandLineRunner {
    private final SessionVoteRepository sessionVoteRepository;
    private final EtatSessionVoteRepository etatSessionVoteRepository;
    private final ProfesseurRepository professeurRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        EtatSessionVote etatEnCours = etatSessionVoteRepository.findAll().stream()
                .filter(etat -> "En cours".equals(etat.getLibelle()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Etat 'En cours' introuvable"));

        EtatSessionVote etatTermine = etatSessionVoteRepository.findAll().stream()
                .filter(etat -> "Terminé".equals(etat.getLibelle()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Etat 'Terminé' introuvable"));

        List<Professeur> professeurs = professeurRepository.findAll();

        for (Professeur professeur : professeurs) {
            SessionVote sessionEnCours = new SessionVote();
            sessionEnCours.setIsActive(true);
            sessionEnCours.setDateDebut(LocalDate.now().plusDays(faker.number().numberBetween(1, 5)));
            sessionEnCours.setDateFin(sessionEnCours.getDateDebut().plusDays(7));
            sessionEnCours.setHeureDebut(LocalTime.of(faker.number().numberBetween(8, 12), 0));
            sessionEnCours.setHeureFin(LocalTime.of(faker.number().numberBetween(14, 18), 0));
            sessionEnCours.setProfesseur(professeur);
            sessionEnCours.setEtatSessionVote(etatEnCours);
            sessionVoteRepository.save(sessionEnCours);

            SessionVote sessionTerminee = new SessionVote();
            sessionTerminee.setIsActive(false);
            sessionTerminee.setDateDebut(LocalDate.now().minusDays(faker.number().numberBetween(10, 20)));
            sessionTerminee.setDateFin(sessionTerminee.getDateDebut().plusDays(7));
            sessionTerminee.setHeureDebut(LocalTime.of(faker.number().numberBetween(8, 12), 0));
            sessionTerminee.setHeureFin(LocalTime.of(faker.number().numberBetween(14, 18), 0));
            sessionTerminee.setProfesseur(professeur);
            sessionTerminee.setEtatSessionVote(etatTermine);
            sessionVoteRepository.save(sessionTerminee);
        }
    }
}
