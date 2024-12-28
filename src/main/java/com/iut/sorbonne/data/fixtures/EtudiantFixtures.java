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

import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Component
@Order(5)
public class EtudiantFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final EtudiantRepository etudiantRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("fr"));
        List<Classe> classes = classeRepository.findAll();
        for (Classe classe : classes) {
            for (int i = 0; i < 20; i++) {
                Etudiant etudiant = new Etudiant();
                etudiant.setIdentifiant(faker.numerify("########"));
                etudiant.setNom(faker.name().lastName());
                etudiant.setPrenom(faker.name().firstName());
                etudiant.setTelephone(faker.phoneNumber().cellPhone());
                etudiant.setEmail(faker.internet().emailAddress());
                etudiant.setAdresse(faker.address().cityName());
                etudiant.setIsActive(true);
                etudiant.setIsVoted(false);
                etudiant.setClasse(classe);
                etudiantRepository.save(etudiant);
            }
        }

    }
}
