# Selenium Test Automation Framework

An industry-standard Selenium WebDriver test automation framework built with Java, Maven, TestNG, Page Object Model (POM), Log4j2, and Extent Reports.

## 📋 Table of Contents
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup Instructions](#setup-instructions)
- [Running Tests](#running-tests)
- [Reports](#reports)
- [Configuration](#configuration)
- [Contributing](#contributing)

## ✨ Features

- **Page Object Model (POM)**: Clean separation of test logic and page elements
- **TestNG Framework**: Powerful test configuration and parallel execution support
- **Extent Reports**: Beautiful HTML reports with screenshots
- **Log4j2**: Comprehensive logging for debugging
- **WebDriverManager**: Automatic driver management
- **Maven**: Dependency and build management
- **Git Ready**: Pre-configured .gitignore for version control
- **Parallel Execution**: Support for running tests in parallel
- **Screenshot on Failure**: Automatic screenshot capture on test failures
- **Configurable**: Externalized configuration via properties file

## 🛠 Tech Stack

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 11+ | Programming Language |
| Selenium WebDriver | 4.16.1 | Browser Automation |
| TestNG | 7.8.0 | Test Framework |
| Maven | 3.x | Build Tool |
| Log4j2 | 2.21.1 | Logging |
| Extent Reports | 5.1.1 | Reporting |
| WebDriverManager | 5.6.2 | Driver Management |

## 📁 Project Structure

```
selenium-framework/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/automation/
│   │   │       ├── base/
│   │   │       │   ├── BasePage.java
│   │   │       │   └── BaseTest.java
│   │   │       ├── listeners/
│   │   │       │   └── TestListener.java
│   │   │       ├── pages/
│   │   │       │   └── FacebookLoginPage.java
│   │   │       └── utils/
│   │   │           ├── ConfigReader.java
│   │   │           ├── ExtentReportManager.java
│   │   │           └── ScreenshotUtility.java
│   │   └── resources/
│   │       ├── config.properties
│   │       └── log4j2.xml
│   └── test/
│       ├── java/
│       │   └── com/automation/tests/
│       │       └── FacebookLoginTest.java
│       └── resources/
├── logs/
├── screenshots/
├── test-output/
├── .gitignore
├── pom.xml
├── testng.xml
└── README.md
```

## 📋 Prerequisites

Before running this framework, ensure you have:

- **Java JDK 11 or higher** installed
  ```bash
  java -version
  ```

- **Maven 3.x** installed
  ```bash
  mvn -version
  ```

- **Git** installed (optional, for version control)
  ```bash
  git --version
  ```

## 🚀 Setup Instructions

### 1. Clone or Extract the Project

If using Git:
```bash
git clone <repository-url>
cd selenium-framework
```

Or simply extract the ZIP file and navigate to the project directory.

### 2. Install Dependencies

```bash
mvn clean install -DskipTests
```

This will download all required dependencies defined in `pom.xml`.

### 3. Configure the Framework

Edit `src/main/resources/config.properties` to customize:

```properties
# Browser: chrome, firefox, edge
browser=chrome

# Headless mode: true/false
headless=false

# Application URL
app.url=https://www.facebook.com

# Timeouts (in seconds)
implicit.wait=10
explicit.wait=20
page.load.timeout=30
```

## ▶️ Running Tests

### Run All Tests via Maven

```bash
mvn clean test
```

### Run Specific Test Suite

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Run Tests via TestNG XML directly

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run from IDE

1. Import project as Maven project in your IDE (IntelliJ IDEA, Eclipse, etc.)
2. Right-click on `testng.xml` → Run As → TestNG Suite
3. Or right-click on individual test class → Run As → TestNG Test

## 📊 Reports

### Extent Reports

After test execution, find the HTML report at:
```
test-output/ExtentReport_<timestamp>.html
```

Open the HTML file in any browser to view:
- Test execution summary
- Pass/Fail status
- Screenshots of failures
- Execution timeline
- System information

### TestNG Reports

Default TestNG reports are available at:
```
test-output/index.html
```

### Logs

Application logs are stored in:
```
logs/automation.log
```

### Screenshots

Failure screenshots are saved in:
```
screenshots/
```

## ⚙️ Configuration

### Adding New Tests

1. Create a new test class in `src/test/java/com/automation/tests/`
2. Extend `BaseTest` class
3. Add test methods with `@Test` annotation
4. Update `testng.xml` to include the new test class

Example:
```java
public class NewTest extends BaseTest {
    
    @Test
    public void testExample() {
        // Your test code
    }
}
```

### Adding New Page Objects

1. Create a new page class in `src/main/java/com/automation/pages/`
2. Extend `BasePage` class
3. Define page elements using `@FindBy` annotations
4. Add page methods

Example:
```java
public class NewPage extends BasePage {
    
    @FindBy(id = "elementId")
    private WebElement element;
    
    public NewPage(WebDriver driver) {
        super(driver);
    }
    
    public void clickElement() {
        clickElement(element, "Element Name");
    }
}
```

### Parallel Execution

To run tests in parallel, modify `testng.xml`:

```xml
<suite name="Test Suite" parallel="tests" thread-count="3">
    <!-- your test configuration -->
</suite>
```

Options for `parallel` attribute:
- `methods` - Run test methods in parallel
- `tests` - Run test tags in parallel
- `classes` - Run test classes in parallel

## 📝 Test Scenarios Included

### Facebook Login Tests

1. **testLoginPageLoad** - Verify login page loads successfully
2. **testLoginPageElements** - Verify all UI elements are present
3. **testLoginPageTitle** - Verify page title
4. **testLoginWithEmptyCredentials** - Test empty credentials validation
5. **testLoginWithInvalidEmailFormat** - Test invalid email format
6. **testLoginWithEmptyPassword** - Test empty password validation
7. **testLoginWithInvalidCredentials** - Test invalid login attempt
8. **testForgotPasswordLink** - Verify forgot password functionality
9. **testCreateNewAccountButton** - Verify signup button functionality
10. **testLoginWithSpecialCharacters** - Test special characters handling

## 🐛 Troubleshooting

### WebDriver Issues

If you encounter driver-related issues:
```bash
mvn clean install -DskipTests
```

WebDriverManager automatically downloads the correct driver version.

### Port Already in Use

If you see "port already in use" error, kill the process:
```bash
# Windows
taskkill /F /IM chromedriver.exe

# Mac/Linux
killall chromedriver
```

### Tests Not Running

1. Verify Java and Maven are properly installed
2. Check `testng.xml` is correctly configured
3. Ensure all dependencies are downloaded: `mvn clean install`

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📧 Support

For issues and questions:
- Create an issue in the repository
- Check existing documentation
- Review logs in `logs/automation.log`

## 📄 License

This project is licensed under the MIT License.

## 👏 Acknowledgments

- Selenium WebDriver Team
- TestNG Framework
- Extent Reports
- Log4j Team
- WebDriverManager

---

Initial commit from Eclipse
