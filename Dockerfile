FROM maven:3.8.2-openjdk-17 as builder
LABEL authors="Almas Estiak"

WORKDIR /application

COPY . /application
RUN mvn dependency:go-offline

ARG JAR_FILE=/application/target/*.jar

FROM amazoncorretto:17
WORKDIR /application
COPY --from=builder /application/target/*.jar ./app.jar

# Expose the application port
EXPOSE 8080

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]