package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.entities.DateSession;
import com.iut.sorbonne.data.entities.SessionVote;
import com.iut.sorbonne.data.repositories.DateSessionRepository;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@RequiredArgsConstructor
@Component
@Order(6)
public class DateSessionFixtures implements CommandLineRunner {
    private final DateSessionRepository dateSessionRepository;
    private final SessionVoteRepository sessionVoteRepository;
    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i <= 10L; i++) {
            SessionVote sessionVote = sessionVoteRepository.findById(i).orElse(null);
            DateSession dateSession = new DateSession();
            dateSession.setId(i);

            dateSession.setSessionVote(sessionVote);
            dateSession.setDateDebut(LocalDate.now().plusDays(i));
            dateSession.setHeureDebut(LocalTime.of(LocalTime.now().getHour(), 0));

            dateSession.setDateFin(dateSession.getDateDebut().plusDays(1));
            dateSession.setHeureFin(LocalTime.of(LocalTime.now().getHour(), 0));
            dateSession.setIsActive(true);
            dateSessionRepository.save(dateSession);
        }

    }
}
