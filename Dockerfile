FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]