FROM openjdk:11-jdk
EXPOSE 8089
ADD target/gestion-secteuractivite-achat-1.0.jar  mohamedali-azouzi-5bi5-gestion-secteuractivite-achat.jar
ENTRYPOINT ["java","-jar","/mohamedali-azouzi-5bi5-gestion-secteuractivite-achat.jar"]