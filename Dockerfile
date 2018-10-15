from maven:3.5-jdk-8-slim
COPY testA/ /opt/testA
workdir /opt/testA
RUN mvn package
workdir /opt/testA/target
CMD java -jar testA-0.0.1-SNAPSHOT.jar