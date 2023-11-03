FROM adoptopenjdk:8-jdk-hotspot
WORKDIR /app

RUN apt-get update && apt-get install -y \
  curl \
  ca-certificates \
  && rm -rf /var/lib/apt/lists/*

ENV JAR_URL=http://192.168.162.222:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar

RUN curl -o achat-1.0.jar ${JAR_URL}

# COPY target/my-spring-boot-achat-1.0.jar achat-1.0.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","achat-1.0.jar"]