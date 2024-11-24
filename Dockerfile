FROM openjdk:17-alpine
WORKDIR /app
COPY ./target/CbaWrapper.jar /app.jar
EXPOSE 8500
ENTRYPOINT ["java", "-jar", "/app.jar"]
