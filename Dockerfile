
FROM amazoncorretto:20-alpine-jdk

COPY target/TomasMazzzo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
 
ENTRYPOINT ["java", "-jar", "/app.jar"]   