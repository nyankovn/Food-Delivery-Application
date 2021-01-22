FROM maven:3.6.3-openjdk-15 AS build
COPY src /food-delivery-app/src
COPY pom.xml /food-delivery-app
RUN mvn -f /food-delivery-app/pom.xml clean
RUN mvn -f /food-delivery-app/pom.xml install

#
# Package stage
#
FROM openjdk:15
COPY --from=build /food-delivery-app/target/fooddeliveryapplication.jar fooddeliveryapplication.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","fooddeliveryapplication.jar"]