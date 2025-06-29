# Stage 1 – Build fat JAR with Gradle
FROM gradle:8.4.1-jdk17-alpine AS builder
WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src ./src

RUN gradle shadowJar -x test --no-daemon

# Stage 2 – Runtime with minimal JRE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=builder /app/build/libs/commandos-all.jar .

RUN mkdir -p data plugins

ENTRYPOINT ["java", "-jar", "commandos-all.jar"]
# EXPOSE 8080 (optional)
