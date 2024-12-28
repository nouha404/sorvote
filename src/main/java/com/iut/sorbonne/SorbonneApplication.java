package com.iut.sorbonne;

import com.iut.sorbonne.data.entities.SessionVote;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class SorbonneApplication implements CommandLineRunner {
	private final SessionVoteRepository sessionVoteRepository;

	public static void main(String[] args) {
		SpringApplication.run(SorbonneApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		List<SessionVote> sessionVotes = sessionVoteRepository.findAllByIsActiveTrue();
		sessionVotes.forEach(sessionVote -> {
			System.out.println(sessionVote);
			System.out.println(sessionVote.getProfesseur()); // Accès explicite à une relation paresseuse
		});
	}


}
