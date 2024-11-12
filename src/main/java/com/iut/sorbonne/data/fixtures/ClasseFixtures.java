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
@Order(3)
public class ClasseFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final NiveauRepository niveauRepository;
    private final FiliereRepository filiereRepository;
    @Override
    public void run(String... args) throws Exception {

        for (ENiveau libelle : ENiveau.values()) {
            Niveau niveau = niveauRepository.findById(libelle.getIndex()).orElse(null);
            for (EFiliere filiere : EFiliere.values()) {
                Filiere fl = filiereRepository.findById(filiere.getIndex()).orElse(null);
                if (niveau != null && fl != null) {
                    Classe classe = new Classe();
                    classe.setLibelle(libelle.name() + filiere.name());
                    classe.setIsActive(true);
                    classe.setNiveau(niveau);
                    classe.setFiliere(fl);
                    classeRepository.save(classe);
                }
            }
        }

    }
}
