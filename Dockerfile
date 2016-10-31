FROM anapsix/alpine-java
MAINTAINER haipq7641@gmail.com

COPY framgia-comments-to-github.jar /scripts/framgia-comments-to-github.jar
COPY violationcomments /bin/violationcomments
RUN chmod +x /bin/violationcomments
