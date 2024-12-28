package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.DocumentFile;
import com.iut.sorbonne.data.repositories.DocumentFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
@Order(8)
public class DocumentFileFixtures  implements CommandLineRunner {
    private final DocumentFileRepository documentFileRepository;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("fr"));
        for (int i = 1; i <= 20; i++) {
            DocumentFile document = new DocumentFile();
            document.setLibelle("Document " + i);
            document.setTypeDocument(faker.file().extension());
            document.setSize(faker.number().numberBetween(1000, 10000));
            document.setUri(faker.internet().url() + "/files/doc" + i + ".pdf");
            documentFileRepository.save(document);
        }
    }
}
