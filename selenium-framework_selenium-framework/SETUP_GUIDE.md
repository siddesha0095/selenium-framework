# Setup Guide - Selenium Test Automation Framework

This guide will help you set up and run the Selenium Test Automation Framework on your machine.

## 📋 Prerequisites Installation

### 1. Install Java JDK 11 or Higher

#### Windows:
1. Download JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [AdoptOpenJDK](https://adoptopenjdk.net/)
2. Run the installer
3. Set JAVA_HOME environment variable:
   - Right-click 'This PC' → Properties → Advanced System Settings
   - Environment Variables → New (System Variables)
   - Variable name: `JAVA_HOME`
   - Variable value: `C:\Program Files\Java\jdk-11.x.x`
4. Add to PATH: `%JAVA_HOME%\bin`
5. Verify: Open CMD and run `java -version`

#### Mac:
```bash
# Using Homebrew
brew install openjdk@11

# Add to PATH
echo 'export PATH="/usr/local/opt/openjdk@11/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc

# Verify
java -version
```

#### Linux:
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install openjdk-11-jdk

# Verify
java -version
```

### 2. Install Apache Maven

#### Windows:
1. Download Maven from [Apache Maven](https://maven.apache.org/download.cgi)
2. Extract to `C:\Program Files\Apache\maven`
3. Set M2_HOME environment variable:
   - Variable name: `M2_HOME`
   - Variable value: `C:\Program Files\Apache\maven`
4. Add to PATH: `%M2_HOME%\bin`
5. Verify: `mvn -version`

#### Mac:
```bash
brew install maven
mvn -version
```

#### Linux:
```bash
sudo apt update
sudo apt install maven
mvn -version
```

### 3. Install Git (Optional)

#### Windows:
Download from [git-scm.com](https://git-scm.com/downloads)

#### Mac:
```bash
brew install git
```

#### Linux:
```bash
sudo apt install git
```

### 4. Install IDE (Recommended)

Choose one:
- **IntelliJ IDEA** (Recommended): [Download](https://www.jetbrains.com/idea/download/)
- **Eclipse**: [Download](https://www.eclipse.org/downloads/)
- **VS Code** with Java extensions: [Download](https://code.visualstudio.com/)

## 🚀 Framework Setup

### Step 1: Extract the Framework

1. Extract the `selenium-framework.zip` file
2. Navigate to the extracted folder

### Step 2: Import Project in IDE

#### IntelliJ IDEA:
1. Open IntelliJ IDEA
2. File → Open
3. Select the `selenium-framework` folder
4. Wait for Maven to download dependencies (see progress at bottom)
5. If prompted, enable auto-import for Maven

#### Eclipse:
1. Open Eclipse
2. File → Import → Maven → Existing Maven Projects
3. Browse to `selenium-framework` folder
4. Click Finish
5. Wait for dependencies to download

#### VS Code:
1. Open VS Code
2. File → Open Folder
3. Select `selenium-framework`
4. Install Java Extension Pack if prompted
5. Maven will auto-import

### Step 3: Download Dependencies

Open terminal in project root and run:

```bash
mvn clean install -DskipTests
```

This will:
- Download all required JAR files
- Set up the project structure
- Verify everything is configured correctly

**Expected output:**
```
[INFO] BUILD SUCCESS
```

### Step 4: Verify Setup

Run this command to verify:

```bash
mvn test -Dtest=FacebookLoginTest#testLoginPageLoad
```

If successful, you'll see:
- Browser opens
- Facebook loads
- Test passes
- Report generated in `test-output/`

## ⚙️ Configuration

### Browser Configuration

Edit `src/main/resources/config.properties`:

```properties
# Choose browser: chrome, firefox, edge
browser=chrome

# Run in headless mode (no UI)
headless=false
```

### Test Data Configuration

Update test credentials in `config.properties`:

```properties
valid.email=your_email@example.com
valid.password=your_password
```

**⚠️ Security Note:** Never commit real credentials to Git!

### Logging Configuration

Modify `src/main/resources/log4j2.xml` to change:
- Log levels (DEBUG, INFO, WARN, ERROR)
- Log file location
- Log format

## 📊 Running Tests

### Method 1: Maven Command Line

```bash
# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=FacebookLoginTest

# Run specific test method
mvn test -Dtest=FacebookLoginTest#testLoginPageLoad

# Run with custom TestNG XML
mvn test -DsuiteXmlFile=testng.xml
```

### Method 2: Using Scripts

#### Windows:
Double-click `run-tests.bat` or run in CMD:
```cmd
run-tests.bat
```

#### Mac/Linux:
```bash
./run-tests.sh
```

### Method 3: From IDE

**IntelliJ IDEA:**
1. Right-click on `testng.xml`
2. Click "Run"

**Eclipse:**
1. Right-click on `testng.xml`
2. Run As → TestNG Suite

### Method 4: TestNG Plugin

1. Install TestNG plugin in your IDE
2. Right-click on test class
3. Run As → TestNG Test

## 📁 Understanding the Output

After test execution, you'll find:

### 1. Extent Reports
```
test-output/ExtentReport_<timestamp>.html
```
- Open in browser
- Shows pass/fail status
- Includes screenshots
- Detailed execution logs

### 2. TestNG Reports
```
test-output/index.html
test-output/emailable-report.html
```

### 3. Logs
```
logs/automation.log
```
- Contains detailed execution logs
- Useful for debugging

### 4. Screenshots
```
screenshots/
```
- Captured on test failures
- Named with timestamp

## 🐛 Troubleshooting

### Issue 1: Maven Dependencies Not Downloading

**Solution:**
```bash
# Delete local repository
rm -rf ~/.m2/repository

# Re-download
mvn clean install -U
```

### Issue 2: WebDriver Not Found

**Solution:**
WebDriverManager handles this automatically. If issues persist:
```bash
mvn clean install -DskipTests
```

### Issue 3: Tests Failing Due to Timeouts

**Solution:**
Increase timeouts in `config.properties`:
```properties
implicit.wait=20
explicit.wait=30
page.load.timeout=60
```

### Issue 4: Browser Not Opening

**Possible causes:**
1. Browser not installed (install Chrome/Firefox/Edge)
2. Driver version mismatch (WebDriverManager handles this)
3. Firewall blocking (allow Java through firewall)

**Solution:**
```bash
# Update WebDriverManager
mvn clean install -U
```

### Issue 5: Port Already in Use

**Windows:**
```cmd
taskkill /F /IM chromedriver.exe
taskkill /F /IM java.exe
```

**Mac/Linux:**
```bash
killall chromedriver
killall java
```

### Issue 6: Compilation Errors

**Solution:**
1. Verify Java version: `java -version` (should be 11+)
2. Update Maven: `mvn clean install -U`
3. Rebuild project in IDE

## 🔧 Advanced Configuration

### Parallel Execution

Edit `testng.xml`:
```xml
<suite name="Test Suite" parallel="tests" thread-count="3">
```

### Custom Reports Directory

Edit `pom.xml` or create `maven.properties`:
```properties
maven.test.failure.ignore=true
```

### Running on CI/CD

#### Jenkins:
```bash
mvn clean test -Dheadless=true
```

#### GitHub Actions:
```yaml
- name: Run tests
  run: mvn clean test -Dbrowser=chrome -Dheadless=true
```

## 📚 Next Steps

1. **Add More Tests**: Create new test classes in `src/test/java/com/automation/tests/`
2. **Add More Pages**: Create page objects in `src/main/java/com/automation/pages/`
3. **Customize Reports**: Modify `ExtentReportManager.java`
4. **Add Test Data**: Use Excel/CSV files with Apache POI
5. **Integrate CI/CD**: Set up Jenkins, GitHub Actions, or GitLab CI

## 🆘 Getting Help

If you encounter issues:

1. Check logs in `logs/automation.log`
2. Review console output for errors
3. Verify all prerequisites are installed
4. Check configuration in `config.properties`
5. Ensure dependencies are downloaded: `mvn dependency:tree`

## 📞 Support Resources

- **Selenium Documentation**: [selenium.dev](https://www.selenium.dev/documentation/)
- **TestNG Documentation**: [testng.org](https://testng.org/doc/documentation-main.html)
- **Maven Guide**: [maven.apache.org](https://maven.apache.org/guides/)

---

**You're all set! Happy Testing! 🚀**
