FROM openjdk:17-jdk-slim
LABEL authors="noj2304"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-notification.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar","/ms-notification.jar"]