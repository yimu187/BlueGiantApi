FROM openjdk:11.0.9.1-oraclelinux8
RUN mkdir /usr/src/task-app
RUN cd /usr/src/task-app
COPY task-1.0.4.jar /usr/src/task-app
WORKDIR /usr/src/task-app
EXPOSE 8061
CMD ["java", "-jar", "task-1.0.4.jar"]

