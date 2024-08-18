FROM openjdk:17-jdk-slim
LABEL maintainer="Daniel Tessi" email="daniel.cloudware@gmail.com"
ARG JAR_FILE=target/*.jar
COPY ./target/spring-boot-docker.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080