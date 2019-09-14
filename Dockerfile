FROM openjdk:11-jre-slim

WORKDIR /app

ADD build/libs/*.jar /app/openchain-supervizer.jar

CMD ["java", "-jar", "/app/openchain-supervizer.jar"]

EXPOSE 8900
