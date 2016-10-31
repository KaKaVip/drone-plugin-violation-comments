FROM anapsix/alpine-java
MAINTAINER haipq7641@gmail.com

COPY framgia-comments-to-github.jar /scripts/framgia-comments-to-github.jar
COPY .bashrc /.bashrc
RUN chmod 644 /.bashrc
RUN source /.bashrc
