FROM anapsix/alpine-java
MAINTAINER haipq7641@gmail.com

COPY java-violation-comments.jar /scripts/java-violation-comments.jar

ENTRYPOINT ["java", "-jar", "/scripts/java-violation-comments.jar"]
