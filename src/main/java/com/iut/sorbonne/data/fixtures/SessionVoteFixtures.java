package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.*;
import com.iut.sorbonne.data.repositories.EtatSessionVoteRepository;
import com.iut.sorbonne.data.repositories.ProfesseurRepository;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import com.iut.sorbonne.data.repositories.TendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;

@RequiredArgsConstructor
@Component
@Order(6)
public class SessionVoteFixtures implements CommandLineRunner {
    private final SessionVoteRepository sessionVoteRepository;
    private final ProfesseurRepository professeurRepository;
    private final EtatSessionVoteRepository etatSessionVoteRepository;
    private final TendanceRepository tendanceRepository;

    @Override
    public void run(String... args) throws Exception {
        for(long i = 1L; i<=10L; i++) {
            Faker faker = new Faker();
            Professeur professeur = professeurRepository.findById(i).orElse(null);
            EtatSessionVote etatSessionVote = etatSessionVoteRepository.findById(i).orElse(null);
            Tendance tendance = tendanceRepository.findById(i).orElse(null);
            SessionVote sessionVote = new SessionVote();
            sessionVote.setId(i);
            sessionVote.setIsActive(true);

            sessionVote.setDateDebut(LocalDate.now().plusDays(i));
            sessionVote.setDateFin(sessionVote.getDateDebut().plusDays(i));
            sessionVote.setHeureDebut(LocalTime.of(LocalTime.now().getHour(), 0));
            sessionVote.setHeureFin(LocalTime.of(LocalTime.now().getHour(), 0));

            sessionVote.setProfesseur(professeur);
            sessionVote.setEtatSessionVote(etatSessionVote);
            if (tendance == null) {
                Candidat candidat = new Candidat();
                candidat.setNombreDeVote(i);
                candidat.setNom(faker.name().firstName());
                candidat.setPrenom(faker.name().firstName());
                candidat.setTelephone(faker.phoneNumber().phoneNumber());
                candidat.setEmail(faker.internet().emailAddress());
                candidat.setAdresse(faker.address().fullAddress());
                candidat.setIdentifiant(faker.numerify("########"));
                candidat.setIsActive(true);
                Tendance newTendance = Tendance.builder()
                        .sessionVote(sessionVote)
                        .candidats(Collections.singletonList(candidat))
                        .build();
                sessionVote.setTendance(newTendance);
            }
            sessionVoteRepository.save(sessionVote);


        }

    }
}
