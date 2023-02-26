FROM eclipse-temurin
COPY target/*.jar /app.jar

ENV USERNAME=postgres
ENV PASSWORD=password
ENV URL =jdbc:postgresql://localhost:5432/software
ENTRYPOINT ["java","-jar","/app.jar"]