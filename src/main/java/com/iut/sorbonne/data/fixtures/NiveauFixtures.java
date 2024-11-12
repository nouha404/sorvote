package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.entities.Niveau;
import com.iut.sorbonne.data.enums.ENiveau;
import com.iut.sorbonne.data.repositories.NiveauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
@RequiredArgsConstructor
public class NiveauFixtures  implements CommandLineRunner {
    private final NiveauRepository niveauRepository;

    @Override
    public void run(String... args) throws Exception {
        for (ENiveau libelle : ENiveau.values()) {
            Niveau niveau = new Niveau();

            niveau.setLibelle(ENiveau.valueOf(libelle.name()));
            niveau.setIsActive(true);
            niveauRepository.save(niveau);

        }

    }
}
/*
* Niveau
Filiere
Classe /
Professeur @Order(4)
EtatSession @Order(5)
DateSession @Order(6)
-------------------------
SessionVote 7
Etudiant
Audio
Document
Tendance
Candidat
-------------------------
Tendance @Order(7)
Audio @Order(8)
Document @Order(9)
Etudiant @Order(10)
Candidat @Order(11)
SessionVote @Order(12)
*
*


*/
