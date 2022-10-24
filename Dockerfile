FROM openjdk:11
EXPOSE 8080

ADD build/libs/spring-auth-0.0.1-SNAPSHOT.jar springbootapp.jar

ENTRYPOINT ["java", "-jar", "springbootapp.jar"]