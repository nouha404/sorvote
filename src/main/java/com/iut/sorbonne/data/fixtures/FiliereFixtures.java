package com.iut.sorbonne.data.fixtures;

import com.iut.sorbonne.data.entities.Filiere;
import com.iut.sorbonne.data.enums.EFiliere;
import com.iut.sorbonne.data.repositories.FiliereRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Order(2)
public class FiliereFixtures implements CommandLineRunner  {
    private final FiliereRepository filiereRepository;

    @Override
    public void run(String... args) throws Exception {
        for (EFiliere libelle : EFiliere.values()){
            Filiere filiere = new Filiere();
            filiere.setIsActive(true);
            filiere.setLibelle(EFiliere.valueOf(libelle.name()));
            filiereRepository.save(filiere);
        }

    }
}
