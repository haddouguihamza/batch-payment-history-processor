FROM openjdk:21-jdk-slim

WORKDIR /src

COPY target/*.jar Balance-Batch-build.jar

EXPOSE 8080

# Set the entrypoint to run the JAR
ENTRYPOINT ["java", "-jar", "Balance-Batch-build.jar"]