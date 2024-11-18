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
//@Component
@Order(8)
public class TendanceFixtures implements CommandLineRunner {
    private final TendanceRepository tendanceRepository;
    private final SessionVoteRepository sessionVoteRepository;
    private final CandidatRepository candidatRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Candidat> candidatList = candidatRepository.findAll();

        List<SessionVote> sessionVotes = sessionVoteRepository.findAll();

        if (!sessionVotes.isEmpty()) {
            // Pour chaque session de vote, créer une tendance et associer les candidats
            for (SessionVote sessionVote : sessionVotes) {
                Tendance tendance = new Tendance();
                tendance.setSessionVote(sessionVote);
                tendance.setCandidats(candidatList);
                tendanceRepository.save(tendance);
            }
        } else {
            System.out.println("Aucune session de vote trouvée.");
        }
    }
}
