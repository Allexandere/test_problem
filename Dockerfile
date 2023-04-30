FROM maven:3.8.5-openjdk-17-slim
WORKDIR /app
COPY . .
EXPOSE 8080
RUN mvn install --no-transfer-progress -DskipTests=true
ENTRYPOINT ["mvn", "spring-boot:run", "Dspring.profiles.active=dev"]