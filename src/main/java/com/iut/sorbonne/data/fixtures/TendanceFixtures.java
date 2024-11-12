package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.entities.Candidat;
import com.iut.sorbonne.data.entities.SessionVote;
import com.iut.sorbonne.data.entities.Tendance;
import com.iut.sorbonne.data.repositories.CandidatRepository;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import com.iut.sorbonne.data.repositories.TendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Order(12)
public class TendanceFixtures implements CommandLineRunner {
    private final TendanceRepository tendanceRepository;
    private final SessionVoteRepository sessionVoteRepository;
    private final CandidatRepository candidatRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Candidat> candidatList = candidatRepository.findAll();
        for (long i=1;i<=sessionVoteRepository.count();i++) {
            SessionVote sessionVote = sessionVoteRepository.findById(i).orElse(null);

            Tendance tendance = new Tendance();
            tendance.setId(i);
            tendance.setSessionVote(sessionVote);
            tendance.setCandidats(candidatList);
            tendanceRepository.save(tendance);

        }

    }
}
