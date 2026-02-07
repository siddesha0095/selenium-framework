# Quick Start Guide

Get up and running with the Selenium Framework in 5 minutes!

## ⚡ Quick Setup

### Prerequisites Check
```bash
java -version    # Should show Java 11 or higher
mvn -version     # Should show Maven 3.x
```

If not installed, see [SETUP_GUIDE.md](SETUP_GUIDE.md)

### Step 1: Extract Framework
```bash
unzip selenium-framework.zip
cd selenium-framework
```

### Step 2: Install Dependencies
```bash
mvn clean install -DskipTests
```

### Step 3: Run Tests
```bash
mvn test
```

## 🎯 What Just Happened?

1. ✅ Framework initialized
2. ✅ Dependencies downloaded
3. ✅ Tests executed on Facebook login page
4. ✅ Reports generated

## 📊 View Results

**Extent Report (Main Report):**
```
test-output/ExtentReport_<timestamp>.html
```

**TestNG Report:**
```
test-output/index.html
```

**Logs:**
```
logs/automation.log
```

## 🔧 Configure Before Running

Edit `src/main/resources/config.properties`:

```properties
# Change browser
browser=chrome    # Options: chrome, firefox, edge

# Run without UI (headless)
headless=false   # Set to true for headless mode

# Application URL
app.url=https://www.facebook.com
```

## 🚀 Run Options

### Option 1: Maven
```bash
mvn clean test
```

### Option 2: Scripts

**Windows:**
```cmd
run-tests.bat
```

**Mac/Linux:**
```bash
./run-tests.sh
```

### Option 3: IDE
1. Import project as Maven
2. Right-click `testng.xml`
3. Run As → TestNG Suite

## 📋 Included Test Scenarios

1. ✅ Login page load verification
2. ✅ UI elements presence check
3. ✅ Page title verification
4. ✅ Empty credentials validation
5. ✅ Invalid email format handling
6. ✅ Empty password validation
7. ✅ Invalid credentials handling
8. ✅ Forgot password link
9. ✅ Create account button
10. ✅ Special characters handling

## 🎨 Framework Features

- ✅ **Page Object Model** - Clean and maintainable
- ✅ **TestNG** - Powerful test framework
- ✅ **Extent Reports** - Beautiful HTML reports
- ✅ **Log4j2** - Comprehensive logging
- ✅ **Screenshots** - Auto-capture on failures
- ✅ **WebDriverManager** - Auto driver setup
- ✅ **Maven** - Dependency management
- ✅ **Git Ready** - Version control configured

## 📁 Project Structure

```
selenium-framework/
├── src/
│   ├── main/java/         # Framework code
│   │   ├── base/          # BaseTest, BasePage
│   │   ├── pages/         # Page Objects
│   │   ├── utils/         # Utilities
│   │   └── listeners/     # TestNG Listeners
│   ├── main/resources/    # Configurations
│   └── test/java/         # Test Classes
├── pom.xml                # Maven config
├── testng.xml             # TestNG config
└── README.md              # Documentation
```

## 🔥 Next Steps

1. **Add More Tests**
   - Create new test class in `src/test/java/com/automation/tests/`
   - Extend `BaseTest`
   - Add `@Test` methods

2. **Add More Pages**
   - Create page class in `src/main/java/com/automation/pages/`
   - Extend `BasePage`
   - Define elements with `@FindBy`

3. **Customize Reports**
   - Modify `ExtentReportManager.java`
   - Update report title/theme

4. **Configure CI/CD**
   - Jenkins, GitHub Actions, GitLab CI
   - Run: `mvn clean test -Dheadless=true`

## ❓ Need Help?

- 📖 **Full Setup Guide:** [SETUP_GUIDE.md](SETUP_GUIDE.md)
- 🏗️ **Architecture Details:** [ARCHITECTURE.md](ARCHITECTURE.md)
- 📚 **Complete README:** [README.md](README.md)

## 🐛 Quick Troubleshooting

**Tests not running?**
```bash
mvn clean install -DskipTests
mvn test
```

**Browser not opening?**
- Install Chrome/Firefox/Edge
- Check config.properties

**Compilation errors?**
```bash
mvn clean install -U
```

**Port in use?**
```bash
# Windows
taskkill /F /IM chromedriver.exe

# Mac/Linux
killall chromedriver
```

## 📞 Support

Check logs for errors:
```
logs/automation.log
```

---

**Ready to go! Happy Testing! 🚀**
