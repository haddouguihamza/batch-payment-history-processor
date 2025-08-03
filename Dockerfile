FROM openjdk:21-jdk-slim

# Set a working directory
WORKDIR /src

COPY target/*.jar Balance-Batch-build.jar

EXPOSE 8080

# Set the entrypoint to run the JAR
ENTRYPOINT ["java", "-jar", "Balance-Batch-build.jar"]