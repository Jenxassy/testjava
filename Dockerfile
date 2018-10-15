from maven:3.5-jdk-8-slim
workdir testA
mvn package
workdir testA/target
CWD java -jar testA-0.0.1-SNAPSHOT.jar