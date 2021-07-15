FROM centos

RUN yum install -y java-11-openjdk
VOLUME /tmp
ADD target/peliculas.jar app.jar

RUN sh -c 'touch /app.jar'
EXPOSE 6666
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar", "/app.jar"]