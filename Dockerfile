# Use a lightweight JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Give permission to Maven wrapper
RUN chmod +x ./mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the jar file (adjust if your jar has a specific name)
CMD ["java", "-jar", "jaroflove/target/jaroflove-0.0.1-SNAPSHOT.jar"]
