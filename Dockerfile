FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/card-operation-mysql-0.0.1-SNAPSHOT.jar cardoperationmysql.jar
EXPOSE 9090
ENTRYPOINT exec java $JAVA_OPTS -jar cardoperationmysql.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar cardoperationmysql.jar
