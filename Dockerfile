FROM eclipse-temurin
COPY target/*.jar /app.jar

# Database
ENV USERNAME=postgres
ENV PASSWORD=password
ENV URL =jdbc:postgresql://localhost:5432/software

# API fixer.io
ENV API_KEY=your_api_key
ENV BASE_URL=https://api.apilayer.com/fixer

ENTRYPOINT ["java","-jar","/app.jar"]
