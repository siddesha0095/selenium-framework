#!/bin/bash

echo "========================================"
echo "Selenium Test Automation Framework"
echo "========================================"
echo ""

echo "Cleaning previous build..."
mvn clean

echo ""
echo "Running tests..."
mvn test

echo ""
echo "========================================"
echo "Test execution completed!"
echo "Check reports in test-output folder"
echo "========================================"
