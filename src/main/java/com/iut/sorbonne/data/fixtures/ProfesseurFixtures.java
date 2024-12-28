package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.Professeur;
import com.iut.sorbonne.data.enums.ESpecialite;
import com.iut.sorbonne.data.repositories.ProfesseurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(6)
public class ProfesseurFixtures implements CommandLineRunner {
    private final ProfesseurRepository professeurRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        for (ESpecialite specialite : ESpecialite.values()) {
            for (int i = 0; i < 2; i++) {
                Professeur professeur = new Professeur();
                professeur.setNom(faker.name().lastName());
                professeur.setPrenom(faker.name().firstName());
                professeur.setIdentifiant(faker.numerify("########"));
                professeur.setEmail(faker.internet().emailAddress());
                professeur.setESpecialite(specialite);
                professeurRepository.save(professeur);
            }
        }

    }
}
