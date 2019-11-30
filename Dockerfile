FROM openjdk:11.0.4-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/e-scooter-orders-api-1.0-SNAPSHOT.jar /app

EXPOSE 8086

CMD ["java", "-jar", "e-scooter-orders-api-1.0-SNAPSHOT.jar"]