package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.repositories.AudioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(9)
public class AudioFixtures implements CommandLineRunner {
    private final AudioRepository audioRepository;
    @Override
    public void run(String... args) throws Exception {
        for (long i=1;i<=10L;i++) {
               /*
                *  private String libelle;
                private String format;
                private String path;
                private String size;

                @OneToOne
                private Candidat candidat;
                * */
        }


    }
}
