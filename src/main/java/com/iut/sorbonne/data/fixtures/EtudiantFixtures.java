package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.Classe;
import com.iut.sorbonne.data.entities.Etudiant;
import com.iut.sorbonne.data.entities.SessionVote;
import com.iut.sorbonne.data.repositories.ClasseRepository;
import com.iut.sorbonne.data.repositories.EtudiantRepository;
import com.iut.sorbonne.data.repositories.SessionVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
//@Component
@Order(7)
public class EtudiantFixtures implements CommandLineRunner {
    private final SessionVoteRepository sessionVoteRepository;
    private final ClasseRepository classeRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public void run(String... args) throws Exception {
        for(long i = 1L; i<=40L; i++) {
            SessionVote sessionVote = sessionVoteRepository.findById(i).orElse(null);
            Classe classe = classeRepository.findById(i).orElse(null);

            Faker faker = new Faker(new Locale("fr"));
            Etudiant etudiant = new Etudiant();
            etudiant.setId(i);
            etudiant.setIsActive(true);
            etudiant.setIsVoted(false);
            etudiant.setEmail(faker.internet().emailAddress());
            etudiant.setAdresse(faker.address().cityName());
            etudiant.setNom(faker.name().firstName());
            etudiant.setPrenom(faker.name().lastName());
            etudiant.setTelephone(faker.phoneNumber().cellPhone());
            etudiant.setIdentifiant(faker.numerify("########"));
            etudiant.setSessionVote(sessionVote);
            etudiant.setClasse(classe);
            etudiantRepository.save(etudiant);

        }

    }
}
