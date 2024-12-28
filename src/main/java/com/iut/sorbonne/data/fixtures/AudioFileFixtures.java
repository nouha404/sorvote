package com.iut.sorbonne.data.fixtures;

import com.github.javafaker.Faker;
import com.iut.sorbonne.data.entities.AudioFile;
import com.iut.sorbonne.data.repositories.AudioFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
@Order(9)
public class AudioFileFixtures implements CommandLineRunner {
    private final AudioFileRepository audioFileRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(new Locale("fr"));
        for (int i = 1; i <= 20; i++) {
            AudioFile audio = new AudioFile();

            audio.setLibelle("Audio " + i);
            audio.setFormat(faker.options().option("mp3", "wav", "aac"));
            audio.setDuration(faker.number().numberBetween(30, 300));
            audio.setUri(faker.internet().url() + "/files/audio" + i + ".mp3"); // URI factice
            audioFileRepository.save(audio);
        }
    }
}
