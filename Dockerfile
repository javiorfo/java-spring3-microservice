FROM eclipse-temurin:21-jre-alpine

RUN addgroup -S spring && adduser -S spring -G spring

COPY build/libs/*.jar /opt/app.jar

USER spring:spring

WORKDIR /opt

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080
