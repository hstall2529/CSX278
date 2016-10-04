FROM openjdk:8
WORKDIR /app/jhipster-project
MAINTAINER harrison.r.stall@vanderbilt.edu
ADD build/libs/*.war .
EXPOSE 8080
CMD java -jar *.war --spring.profiles.active=dev,swagger
