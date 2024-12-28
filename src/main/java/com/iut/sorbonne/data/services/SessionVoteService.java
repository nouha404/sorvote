package com.iut.sorbonne.data.services;

import com.iut.sorbonne.data.entities.SessionVote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SessionVoteService {
    Page<SessionVote> getAllVotes(Pageable page);

    //SessionVote getVoteById(Long id);
    //void createSessionVote(SessionVote sessionVote);

    //Page<Tendance> getTendanceBySessionVote dans Tendance
    /*
    * - creer une sessions de vote
- lister les etudiants
- filtrer les etudiant par niveau et filiere
- inscrire un etudiant au vote
- desinscrire un etudiant au vote
- lire le document de l'étudiant
- lister les sessions de vote
- filtrer les sessions de vote niveau et filiere
- lister le tendance du sessions de vote
- lister le nombre de vote d'un candidat
- se connecter
- se deconnecter */
}
