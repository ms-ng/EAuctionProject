FROM openjdk:18-alpine
ARG JAR_FILE=api-gateway-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]