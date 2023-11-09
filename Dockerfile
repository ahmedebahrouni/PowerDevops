# Use an official OpenJDK image as the base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/achat-2.1.jar /app/achat-2.1.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8082

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "achat-2.1.jar"]