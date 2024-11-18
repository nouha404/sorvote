package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.Candidat;
import com.iut.sorbonne.data.entities.Tendance;
import com.iut.sorbonne.data.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

@RequiredArgsConstructor
//@Component
@Order(9)
public class CandidatFixtures implements CommandLineRunner {
    private final CandidatRepository candidatRepository;
    private final EtudiantRepository etudiantRepository;
    private final SessionVoteRepository sessionVoteRepository;
    private final TendanceRepository tendanceRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        String documentDirectory = "src/main/resources/static/documents/";
        String audioDirectory = "src/main/resources/static/audios/";

        // Récupère tous les fichiers dans le répertoire
        File[] documentFiles = new File(documentDirectory).listFiles();
        File[] audioFiles = new File(audioDirectory).listFiles();



        int fileIndex = 0;
        Random rand = new Random();
        for (long i=1;i<=sessionVoteRepository.count();i++) {
            Tendance tendance = tendanceRepository.findById(i).orElse(null);
            for (long j = 1; j<= 8L; j++) {


                Candidat.CandidatBuilder candidatBuilder = Candidat.builder()
                        .nombreDeVote(faker.number().numberBetween(0, (int) etudiantRepository.count()))
                        .tendance(tendance);

                // Ajout d'un document avec une probabilité de 50%
                if (rand.nextBoolean() && documentFiles != null && documentFiles.length > 0) {
                    File documentFile = documentFiles[fileIndex % documentFiles.length];

                    String documentPath = documentFile.getAbsolutePath();
                    String documentLibelle = documentFile.getName();
                    long documentSize = Files.size(Paths.get(documentPath));

                    candidatBuilder.documentFormat(getFileExtension(documentLibelle))
                            .documentPath(documentPath)
                            .documentLibelle(documentLibelle)
                            .documentSize(documentSize);
                }

                if (rand.nextBoolean() && audioFiles != null && audioFiles.length > 0) {
                    File audioFile = audioFiles[fileIndex % audioFiles.length];
                    String audioPath = audioFile.getAbsolutePath();
                    String audioLibelle = audioFile.getName();
                    long audioSize = Files.size(Paths.get(audioPath));

                    candidatBuilder.audioLibelle(audioLibelle)
                            .audioFormat(getFileExtension(audioLibelle))
                            .audioPath(audioPath)
                            .audioSize(audioSize);
                }

                // Sauvegarde du candidat
                Candidat candidat = candidatBuilder.build();
                candidatRepository.save(candidat);
                fileIndex++;

            }


        }

    }

    // Obtenir l'extension du fichier
    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        return (lastIndex == -1) ? "" : fileName.substring(lastIndex + 1);
    }

}
