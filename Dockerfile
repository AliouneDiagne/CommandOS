# Stage 1: Build
FROM eclipse-temurin:17-jdk as builder

WORKDIR /app
COPY . .
RUN ./gradlew clean shadowJar

# Stage 2: Run
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/build/libs/commandos-all.jar /app/commandos-all.jar

# Non root user (best practice, optional)
RUN useradd -ms /bin/bash commandos
USER commandos

# Default command
CMD ["java", "-jar", "/app/commandos-all.jar"]
