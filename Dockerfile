FROM arm32v7/eclipse-temurin:17.0.9_9-jdk
#FROM arm32v7/maven:eclipse-temurin
#FROM maven:latest
#FROM arm32v7/eclipse-temurin

#FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp

#WORKDIR .

#ARG JAR_FILE=target/*.jar
#ADD ${JAR_FILE} app.jar
#RUN echo ${PWD}
#RUN ls /home/gitlab-runner/builds/nCPmK5Rz/0/jesuli/restful-web-services/target/*.jar
COPY . .
COPY target/betting-info-*.jar betting-info.jar
ENTRYPOINT ["java","-jar","betting-info.jar"]


#ENTRYPOINT ["mvn","spring-boot:run"]


EXPOSE 8080
