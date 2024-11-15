FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"] 