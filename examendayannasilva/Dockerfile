FROM openjdk:17
EXPOSE 3000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} configserver.jar
ENTRYPOINT ["java","-jar","/configserver.jar"]
