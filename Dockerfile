FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
COPY jaroflove /app/jaroflove
RUN mvn -f jaroflove/pom.xml clean package -DskipTests   # ← skip unit tests

FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/jaroflove/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
