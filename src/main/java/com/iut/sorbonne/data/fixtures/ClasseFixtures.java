package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.entities.Classe;
import com.iut.sorbonne.data.entities.Filiere;
import com.iut.sorbonne.data.entities.Niveau;
import com.iut.sorbonne.data.enums.EFiliere;
import com.iut.sorbonne.data.enums.ENiveau;
import com.iut.sorbonne.data.repositories.ClasseRepository;
import com.iut.sorbonne.data.repositories.FiliereRepository;
import com.iut.sorbonne.data.repositories.NiveauRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(4)
public class ClasseFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final NiveauRepository niveauRepository;
    private final FiliereRepository filiereRepository;
    @Override
    public void run(String... args) throws Exception {

        for (ENiveau niveauEnum : ENiveau.values()) {
            Niveau niveau = niveauRepository.findById(niveauEnum.getIndex()).orElse(null);
            if (niveau == null) continue;

            for (EFiliere filiereEnum : EFiliere.values()) {
                Filiere filiere = filiereRepository.findById(filiereEnum.getIndex()).orElse(null);
                if (filiere == null) continue;

                // Contraintes spécifiques pour les combinaisons
                if (isCombinationAllowed(niveauEnum, filiereEnum)) {
                    Classe classe = new Classe();
                    classe.setLibelle(niveauEnum.name() + " - " + filiereEnum.name());
                    classe.setIsActive(true);
                    classe.setNiveau(niveau);
                    classe.setFiliere(filiere);
                    classeRepository.save(classe);
                }
            }
        }

    }

    private boolean isCombinationAllowed(ENiveau niveau, EFiliere filiere) {
        switch (niveau) {
            case BUT1:
            case BUT2:
            case BUT3:
                return filiere.ordinal() < 8;
            case LP:
                // Les filières Licence Pro (1 seul niveau autorisé)
                return filiere.ordinal() >= 8 && filiere.ordinal() <= 10;
            case M1:
            case M2:
                // Les masters n'ont pas de filière spécifique ici
                return false; // Pas de combinaison pour M1 et M2
            default:
                return false;
        }
    }
}
