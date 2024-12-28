package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.*;
import com.iut.sorbonne.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@RequiredArgsConstructor
@Component
@Order(10)
public class CandidatFixtures implements CommandLineRunner {
    private final CandidatRepository candidatRepository;
    private final ClasseRepository classeRepository;
    private final DocumentFileRepository documentFileRepository;
    private final AudioFileRepository audioFileRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        List<Classe> classes = classeRepository.findAll();
        List<DocumentFile> documents = documentFileRepository.findAll();
        List<AudioFile> audios = audioFileRepository.findAll();

        if (documents.isEmpty() || audios.isEmpty()) {
            throw new RuntimeException("Les listes de documents ou d'audios sont vides.");
        }

        int documentIndex = 0;
        int audioIndex = 0;

        for (Classe classe : classes) {
            // Générer un nombre aléatoire de candidats entre 2 et 4
            int nbCandidats = faker.number().numberBetween(2, 5);

            for (int i = 0; i < nbCandidats; i++) {
                // Vérifier la disponibilité des fichiers
                if (documentIndex >= documents.size() || audioIndex >= audios.size()) {
                    System.out.println("Pas assez de fichiers disponibles pour créer des candidats supplémentaires.");
                    break;
                }

                // Créer un nouveau candidat
                Candidat candidat = new Candidat();
                candidat.setNom(faker.name().lastName());
                candidat.setPrenom(faker.name().firstName());
                candidat.setEmail(faker.internet().emailAddress());
                candidat.setAdresse(faker.address().fullAddress());
                candidat.setTelephone(faker.phoneNumber().cellPhone());
                candidat.setIsActive(true);
                candidat.setNombreDeVote((long) faker.number().numberBetween(0, 100));
                candidat.setClasse(classe);

                // Associer un document et un fichier audio
                candidat.setDocument(documents.get(documentIndex++));
                candidat.setAudio(audios.get(audioIndex++));

                // Sauvegarder le candidat
                candidatRepository.save(candidat);
            }
        }

        System.out.println("Fixtures for Candidat created successfully!");
    }
}
