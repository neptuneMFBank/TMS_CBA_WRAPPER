FROM eclipse-temurin:11-jdk
WORKDIR /app
COPY ./target/CbaWrapper.jar /app.jar
EXPOSE 8500
ENTRYPOINT ["java", "-jar", "/app.jar"]
