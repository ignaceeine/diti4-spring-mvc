# syntax=docker/dockerfile:1

# Stage 1 : build
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Cache des dependances : on copie d'abord le pom
COPY pom.xml .
RUN mvn -B -q dependency:go-offline

# Puis le code source et build
COPY src ./src
RUN mvn -B -q clean package -DskipTests

# Stage 2 : runtime Tomcat 9
FROM tomcat:9.0-jre21-temurin
# On supprime les webapps par defaut
RUN rm -rf /usr/local/tomcat/webapps/*

# Le WAR est deploye a la racine (context path "/")
COPY --from=build /app/target/diti4_spring_mvc.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
