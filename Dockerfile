# Use an official Maven image as the base image
FROM maven:3.8.7-openjdk-17

# Set the working directory inside the container
WORKDIR /app

# Copy the project files (pom.xml and src)
COPY pom.xml .
COPY src ./src

# Install dependencies (optional step to cache dependencies)
RUN mvn dependency:go-offline

# Build the Java automation project
RUN mvn clean package

# Define the command to run tests when the container starts
CMD ["mvn", "test"]
