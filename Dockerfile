FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy the built JAR file (you need to build it first with Maven)
COPY target/*.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]


## Build stage
#FROM maven:3.8-openjdk-21 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Run stage
#FROM openjdk:21-jdk-slim
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
#EXPOSE 8082
#ENTRYPOINT ["java", "-jar", "app.jar"]