# CSI3540 - Laboratoire 4 (Servlets/Tomcat)

Application web Java Servlet conforme au laboratoire 4: inscription, cookies, session, examen en 2 pages, résultat et protection des routes.

## Run (IntelliJ + Tomcat)
1. Ouvrir le projet Maven dans IntelliJ et laisser l'indexation Maven se terminer.
2. Ajouter un serveur `Tomcat 9`:
   - `Run > Edit Configurations... > + > Tomcat Server > Local`.
3. Dans l'onglet `Deployment`:
   - Ajouter l'artefact `CSI3540-LAB4:war exploded`.
4. Vérifier l'URL de contexte (exemple: `/CSI3540-LAB4`).
5. Lancer Tomcat puis ouvrir:
   - `http://localhost:8080/CSI3540-LAB4/`

## Test rapide
1. Ouvrir `/register`, soumettre un `username` valide.
2. Répondre aux 2 questions (`/exam1` puis `/exam2`) et vérifier `/result`.
3. Cliquer `Logout` et vérifier retour vers `/register`.
4. Tenter d'ouvrir directement `/exam1`, `/exam2`, `/result` sans session: redirection vers `/register`.
5. Revenir à `/register` après un passage: le `username` est pré-rempli via cookie.
6. Attendre plus de 10 minutes d'inactivité (ou invalider session) puis retenter `/exam1`: redirection vers `/register`.

## Choix techniques
- Le projet cible `Tomcat 9` et `javax.servlet` pour rester aligné avec la compatibilité habituelle du cours.
- En cas d'ambiguïté de formulation, l'option la plus simple a été choisie: examen de 2 questions arithmétiques, une par page.
