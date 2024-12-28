# SorVote API

### UML

<img src="src/main/resources/static/img_2.png">
<img src="src/main/resources/static/img_1.png">


# les usecases
- creer une sessions de vote 
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
- se deconnecter 

# Ordre de Création des Fixtures

- EtatSessionVote (indépendant).
- Filiere (indépendant).
- Niveau (indépendant).
- Classe (dépend de Filiere et Niveau).
- Etudiant (dépend de Classe).
- Professeur (indépendant).
- SessionVote (dépend de EtatSessionVote, Professeur, et Etudiant).
- DocumentFile et AudioFile (indépendants).
- Candidat (dépend de Etudiant, DocumentFile, et AudioFile).
- Tendance (dépend de SessionVote et Candidat).