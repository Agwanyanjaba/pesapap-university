FROM openjdk:17-jdk
WORKDIR /app
COPY target/fee-notification-microservice-0.0.1-SNAPSHOT.jar fee-notification-microservice.jar
EXPOSE 9091
CMD ["java", "-jar", "fee-notification-microservice.jar"]
