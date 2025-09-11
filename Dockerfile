# Étape 1: Build avec Maven
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Copie les fichiers du projet
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Compile le projet
RUN mvn clean package -DskipTests

# Étape 2: Image finale
FROM eclipse-temurin:17-jre-alpine

# Répertoire de travail
WORKDIR /app

# Copie le JAR depuis l'étape de build
COPY --from=builder /app/target/personneProjet-1.0-SNAPSHOT.jar app.jar

# Expose le port par défaut de Spring Boot
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
