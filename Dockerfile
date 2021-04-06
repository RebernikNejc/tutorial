FROM openjdk:11
COPY ./target/tutorial-1.0.0.jar tutorial.jar
ENTRYPOINT ["java", "-jar", "tutorial.jar"]