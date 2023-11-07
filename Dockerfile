FROM openjdk:8

EXPOSE 8089

WORKDIR /app


ENV NEXUS_USERNAME=admin
ENV NEXUS_PASSWORD=nexus

ENV NEXUS_URL=http://192.168.1.120:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar

RUN curl -L -o achat.jar -u $NEXUS_USERNAME:$NEXUS_PASSWORD  $NEXUS_URL

ENTRYPOINT ["java","-jar","achat.jar"]
