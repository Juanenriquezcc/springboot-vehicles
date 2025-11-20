#!/bin/bash

echo "Building Vehicle API Spring Boot Application..."
echo

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven is not installed or not in the system PATH"
    echo "Please install Maven and ensure it's in the system PATH"
    echo "Visit: https://maven.apache.org/install.html"
    exit 1
fi

echo "✅ Maven found"
echo
echo "Compiling the project..."
echo

# Clean and compile the project
mvn clean compile

if [ $? -eq 0 ]; then
    echo
    echo "✅ Build successful!"
    echo
    echo "To run the application, use:"
    echo "mvn spring-boot:run"
    echo
    echo "Or create the executable JAR with:"
    echo "mvn clean package"
    echo "java -jar target/vehicle-api-1.0.0.jar"
else
    echo
    echo "❌ Build failed"
    echo "Please review the error messages above"
fi

echo