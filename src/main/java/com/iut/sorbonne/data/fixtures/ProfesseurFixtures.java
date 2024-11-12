package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.Professeur;
import com.iut.sorbonne.data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
@Order(4)
public class ProfesseurFixtures implements CommandLineRunner {
    private final ProfesseurRepository professeurRepository;

    @Override
    public void run(String... args) throws Exception {
        for (long i = 1L; i<=10L; i++) {
            Faker faker = new Faker(new Locale("fr"));

            Professeur professeur = new Professeur();
            professeur.setId(i);
            professeur.setNom(faker.name().firstName());
            professeur.setPrenom(faker.name().lastName());
            professeur.setIdentifiant(faker.numerify("########"));
            professeur.setEmail(faker.internet().emailAddress());
            professeurRepository.save(professeur);
        }

    }
}
