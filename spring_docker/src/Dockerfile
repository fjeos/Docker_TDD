#FROM openjdk:17
#COPY HelloDocker.java /
#RUN javac HelloDocker.java
#CMD ["java", "HelloDocker"]

FROM mysql:8.0
ENV MYSQL_ROOT_PASSWORD=rootpassword
ENV MYSQL_DATABASE=myapp
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=userpassword

COPY ./sql_scripts/ /docker-entrypoint-initdb.d/

EXPOSE 3306