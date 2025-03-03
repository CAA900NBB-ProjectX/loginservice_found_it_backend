FROM container-registry.oracle.com/java/jdk:23

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY src ./src

RUN ./gradlew build

COPY build/libs/your-application.jar app.jar

EXPOSE 8080

# Set environment variables (optional)
ENV SPRING_PROFILES_ACTIVE=default

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]