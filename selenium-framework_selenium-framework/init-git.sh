#!/bin/bash

# Git Initialization Script for Selenium Framework

echo "Initializing Git repository..."

# Initialize git repository
git init

# Add all files
git add .

# Initial commit
git commit -m "Initial commit: Selenium Test Automation Framework with POM, TestNG, Log4j, and Extent Reports"

echo "Git repository initialized successfully!"
echo ""
echo "To push to remote repository, use:"
echo "git remote add origin <your-repository-url>"
echo "git push -u origin main"
