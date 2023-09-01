FROM openjdk:17
WORKDIR /app
COPY target/MarketApp-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","MarketApp-0.0.1-SNAPSHOT.jar"]


