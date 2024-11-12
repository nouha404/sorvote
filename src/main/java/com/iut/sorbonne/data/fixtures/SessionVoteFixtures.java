package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.entities.DateSession;
import com.iut.sorbonne.data.entities.EtatSessionVote;
import com.iut.sorbonne.data.entities.Professeur;
import com.iut.sorbonne.data.entities.SessionVote;
import com.iut.sorbonne.data.repositories.DateSessionRepository;
import com.iut.sorbonne.data.repositories.EtatSessionVoteRepository;
import com.iut.sorbonne.data.repositories.ProfesseurRepository;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@RequiredArgsConstructor
@Component
@Order(7)
public class SessionVoteFixtures implements CommandLineRunner {
    private final SessionVoteRepository sessionVoteRepository;
    private final ProfesseurRepository professeurRepository;
    private final DateSessionRepository dateSessionRepository;
    private final EtatSessionVoteRepository etatSessionVoteRepository;

    @Override
    public void run(String... args) throws Exception {
        for(long i = 1L; i<=10L; i++) {
            DateSession dateSession = dateSessionRepository.findById(i).orElse(null);
            Professeur professeur = professeurRepository.findById(i).orElse(null);
            EtatSessionVote etatSessionVote = etatSessionVoteRepository.findById(i).orElse(null);

            SessionVote sessionVote = new SessionVote();
            sessionVote.setId(i);
            sessionVote.setIsActive(true);
            sessionVote.setDateSession(dateSession);
            sessionVote.setProfesseur(professeur);
            sessionVote.setEtatSessionVote(etatSessionVote);

            if (dateSession == null ) {
                dateSession = new DateSession();
                dateSession.setDateDebut(LocalDate.now().plusDays(i));
                dateSession.setHeureDebut(LocalTime.of(LocalTime.now().getHour(), 0));
                dateSession.setDateFin(dateSession.getDateDebut().plusDays(1));
                dateSession.setHeureFin(LocalTime.of(LocalTime.now().getHour(), 0));

                sessionVote.setDateSession(dateSession);

            }
            sessionVoteRepository.save(sessionVote);





        }

    }
}
