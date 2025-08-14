FROM openjdk:21-jdk-slim

COPY target/Balance-Batch-0.0.2-SNAPSHOT.jar app.jar

EXPOSE 8080

# Set the entrypoint to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
