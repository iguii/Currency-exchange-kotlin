FROM eclipse-temurin:11-jdk-alpine

VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

# logback con volumenes
COPY src/main/resources/logback.xml /BOOT-INF/classes/logback.xml

# Database
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=password
ENV DB_URL=jdbc:postgresql://10.20.21.64:5432/software

# API fixer.io
ENV API_KEY=xsYaE9qfD8hIewxNS9SneoFLo4RetSHK
ENV BASE_URL=https://api.apilayer.com/fixer

# keycloak configuration
ENV KEYCLOAK_AUTH_SERVER_URL=http://localhost:8081
ENV KEYCLOAK_REALM=software
ENV KEYCLOAK_RESOURCE=backend
ENV KEYCLOAK_CREDENTIALS_SECRET=E6yW1d3RXJit2RubIPfPuX1U3gJdSaG4

#ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.ignacioillanes.CurrencyExchangekotlin.CurrencyExchangeKotlinApplicationKt"]