package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(10)
public class DocumentFixtures implements CommandLineRunner {
    private final DocumentRepository documentRepository;

    @Override
    public void run(String... args) throws Exception {
        for (long i=1;i<=10L;i++) {
               /*
                *   private String libelle;
                    private String format;
                    private Long size;
                    private String path;

                    @OneToOne
                    private Candidat candidat;
                * */
        }

    }
}
