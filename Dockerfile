# Utilise une image Java officielle
FROM openjdk:17-jdk-alpine

# Répertoire de travail dans le conteneur
WORKDIR /app

# Copie le JAR généré dans l'image Docker
COPY target/personneProjet-1.0-SNAPSHOT.jar app.jar

# Expose le port par défaut de Spring Boot
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
