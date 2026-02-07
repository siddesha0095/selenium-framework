@echo off
echo ========================================
echo Selenium Test Automation Framework
echo ========================================
echo.

echo Cleaning previous build...
call mvn clean

echo.
echo Running tests...
call mvn test

echo.
echo ========================================
echo Test execution completed!
echo Check reports in test-output folder
echo ========================================
pause
