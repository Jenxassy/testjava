from maven:3.5-jdk-8-slim
COPY testA /opt/testA
RUNmvn package
workdir opt/testA/target
CWD java -jar testA-0.0.1-SNAPSHOT.jar