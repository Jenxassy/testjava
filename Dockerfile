from java:8u111-jre
cd testA
mvn package
workdir testA/target
CWD java -jar testA-0.0.1-SNAPSHOT.jar