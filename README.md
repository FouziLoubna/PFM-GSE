# PFM-GSE
## Plateforme de gestion des stages étudiants
![image](https://github.com/user-attachments/assets/c7aee460-32bd-4263-b790-146a3b38095b)

### Description
Application web permettant aux étudiants, tuteurs académiques et entreprises de collaborer efficacement dans la gestion des stages universitaires.
# démonstration vidéo
Pour voir une démonstration vidéo, cliquez sur le lien suivant : 
https://drive.google.com/file/d/1n76G5mif7JJUfh8rm7FgmgKsRHPDSpTU/view

### Fonctionnalités principales :
- **Étudiant :**
  - Soumission de demandes de stage.
  - Suivi des tâches assignées.

- **Tuteur académique :**
  - Validation et supervision des stages.
  - Attribution de tâches/objets d'apprentissage.

- **Entreprise :**
  - Publication d'offres de stages.
  - Validation des rapports des stagiaires.

---

## Architecture du logiciel
![WhatsApp Image 2024-12-28 à 02 07 38_cefd337d](https://github.com/user-attachments/assets/22eee2b6-1f65-48cc-a8dc-36a0aafbef84)

### Docker Image

L'application peut être exécutée à l'aide de Docker pour faciliter la mise en place de l'environnement de développement et de production.
```yaml
version: "3"

services:
  mysql:
    image: mysql:latest
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: gse
    ports:
      - "3306:3306"

  backend:
    build:
      context: ./GSE_Backend/GSE
    ports:
      - "8085:8085"
    depends_on:
      - mysql
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/gse
      SPRING_DATASOURCE_USERNAME: root
      SPRING_DATASOURCE_PASSWORD: root
    healthcheck:
      test: "/usr/bin/mysql --user=root --password=root --execute 'SHOW DATABASES;'"
      interval: 5s
      timeout: 2s
      retries: 100

  frontend:
    build:
      context: ./GSE_Frontend/gse
    ports:
      - "80:80"
    depends_on:
      - backend

  phpmyadmin:
    image: phpmyadmin/phpmyadmin
    environment:
      PMA_HOST: mysql
      PMA_PORT: 3306
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "8081:80"
```
---

## Technologies utilisées

### Frontend
- **Angular**
- **HTML**
- **CSS**
- **TypeScript**

### Backend
- **Spring Boot**
- **MySQL**

---

## Structure du projet Backend

Le code backend adopte une structure modulaire et organisée, exploitant la puissance de Spring Boot pour créer une application robuste et évolutive.

1. **com.pfm.gse.GSEApplication**  
   - **Classe principale** : La classe `Application.java` sert de point d'entrée pour l'application Spring Boot. Elle contient la méthode `main` permettant de démarrer l'application.

2. **com.pfm.gse.controllers**  
   - **Contrôleurs** : Le package `controllers` regroupe les classes responsables de la gestion des requêtes HTTP entrantes. Chaque classe de contrôleur est dédiée à une fonctionnalité ou entité spécifique, exposant des endpoints RESTful. Ces classes interagissent avec les services pour traiter les requêtes et fournir des réponses adaptées.

3. **com.pfm.gse.models**  
   - **Entités** : Le package `models` contient les classes qui représentent les entités de données de l'application. Annotées avec les annotations JPA, ces classes définissent la structure des tables dans la base de données MySQL. En général, chaque entité correspond à une table.

4. **com.pfm.gse.repository**  
   - **Interfaces des dépôts** : Le package `repository` inclut des interfaces qui étendent les dépôts Spring Data JPA. Ces interfaces fournissent des méthodes pour les opérations CRUD de base et sont utilisées par les services pour interagir avec la base de données.

5. **com.pfm.gse.services**  
   - **Services** : Le package `services` contient les classes où la logique métier de l'application est centralisée. Ces classes jouent un rôle intermédiaire entre les contrôleurs et les dépôts. Elles traitent les données, appliquent les règles métier et orchestrent les interactions avec les différentes couches pour répondre aux besoins de l'application.

6. **com.pfm.gse.security**  
   - **Contrôleurs de sécurité** : Le package `security.controllers` contient les classes qui gèrent l'authentification et la sécurité.
     - **AuthController** : Ce contrôleur expose des endpoints pour gérer les opérations liées à l'authentification, comme le login (/login) et la mise à jour des utilisateurs (avec changement de mot de passe). Il utilise Spring Security pour vérifier les identifiants des utilisateurs et génère un jeton JWT via le service `JwtUtil`.
   - **Modèles de sécurité** : Les classes comme `LoginRequest`, `LoginResponse`, `User`, et `ErrorResponse` définissent les structures de données utilisées pour les requêtes et réponses liées à la sécurité.
   - **Dépôts** : Le dépôt `UserDao` interagit avec la base de données pour gérer les utilisateurs et leurs informations.
   - **Services** : Le service `JwtUtil` est responsable de la génération et de la validation des jetons JWT, utilisés pour sécuriser les communications entre le client et le serveur.

7. **com.pfm.gse.configurations**  
   - **Configuration globale** : Le package `configurations` contient des classes qui définissent les réglages de l'application.
     - **CorsConfig** : Cette classe configure les règles CORS (Cross-Origin Resource Sharing), permettant au frontend (Angular) d'accéder aux ressources du backend en définissant les domaines autorisés (http://localhost:4200) et les méthodes HTTP acceptées (GET, POST, PUT, DELETE).

---

## Principales Dépendances

1. **spring-boot-starter-data-jpa** : Gestion des bases de données avec Spring Data JPA.
2. **spring-boot-starter-web** : Création d'API REST et applications web.
3. **spring-boot-starter-security** : Authentification et sécurité.
4. **jjwt** : Génération et validation de JWT.
5. **jaxb-api** : Manipulation des fichiers XML.
6. **MySQL Connector** : JDBC driver pour connecter à MySQL.
7. **spring-boot-starter-test** : Outils pour tests unitaires et d'intégration.
8. **spring-boot-maven-plugin** : Packager l'application en JAR/WAR.

---

## Installation et Exécution

### Prérequis

- **JDK 8** ou supérieur.
- **MySQL** pour la base de données.
- **Docker** (facultatif, pour la gestion de l'environnement).

### Étapes d'installation

1. Clonez le projet à partir du dépôt Git :
   ```bash
   git clone https://github.com/FouziLoubna/PFM-GSE.git
