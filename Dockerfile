from java:8u111-jre
workdir testA
mvn package
workdir testA/target
CWD java -jar testA-0.0.1-SNAPSHOT.jar