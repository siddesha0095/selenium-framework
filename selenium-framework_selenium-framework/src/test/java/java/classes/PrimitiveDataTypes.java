package java.classes;



/**
 * PrimitiveDataTypes - Comprehensive guide with automation context
 * 
 * Purpose: Understanding primitive types and their real-world usage in test automation
 * 
 * Memory Allocation:
 * - Primitives stored in STACK memory (faster access)
 * - Small memory footprint
 * - Direct value storage
 * 
 * @author Senior SDET
 * @version 1.0
 * @since 2024-02-08
 */
public class PrimitiveDataTypes {
    
    // ============================================================
    // INTEGER TYPES - Whole Numbers
    // ============================================================
    
    /**
     * BYTE - 8 bits (1 byte)
     * Range: -128 to 127
     * 
     * AUTOMATION USE CASES:
     * ✅ Retry counts (small numbers)
     * ✅ Status codes (limited range)
     * ✅ Thread pool size (for small parallel execution)
     * ❌ NOT for: IDs, large counters
     */
    public void demonstrateByte() {
        byte maxRetryCount = 3;
        byte threadPoolSize = 5;
        byte httpStatus = 127; // Can't exceed 127!
        
        System.out.println("=== BYTE Type ===");
        System.out.println("Max Retry Count: " + maxRetryCount);
        System.out.println("Thread Pool Size: " + threadPoolSize);
        System.out.println("Memory Size: 1 byte per variable");
        
        // Real-world example: Retry mechanism
        byte currentRetry = 0;
        byte maxRetries = 3;
        
        while (currentRetry < maxRetries) {
            System.out.println("Attempt: " + (currentRetry + 1));
            currentRetry++;
        }
    }
    
    /**
     * SHORT - 16 bits (2 bytes)
     * Range: -32,768 to 32,767
     * 
     * AUTOMATION USE CASES:
     * ✅ Port numbers (1-65535, but Java short is signed)
     * ✅ Small counters
     * ✅ Test data set sizes
     * ❌ Rarely used in modern automation (int is preferred)
     */
    public void demonstrateShort() {
        short httpPort = 8080;
        short httpsPort = 443;
        short testDataCount = 100;
        
        System.out.println("\n=== SHORT Type ===");
        System.out.println("HTTP Port: " + httpPort);
        System.out.println("HTTPS Port: " + httpsPort);
        System.out.println("Test Data Count: " + testDataCount);
        System.out.println("Memory Size: 2 bytes per variable");
    }
    
    /**
     * INT - 32 bits (4 bytes) ⭐ MOST COMMONLY USED
     * Range: -2,147,483,648 to 2,147,483,647
     * 
     * AUTOMATION USE CASES:
     * ✅ Timeouts (seconds, milliseconds)
     * ✅ Element counts
     * ✅ Loop iterations
     * ✅ Test data IDs
     * ✅ HTTP status codes
     * ✅ Array indices
     */
    public void demonstrateInt() {
        // Timeout configurations
        int implicitWaitSeconds = 10;
        int explicitWaitSeconds = 20;
        int pageLoadTimeout = 30;
        int scriptTimeout = 25;
        
        // Test execution metrics
        int totalTestCases = 150;
        int passedTests = 142;
        int failedTests = 8;
        
        // HTTP status codes
        int statusOK = 200;
        int statusNotFound = 404;
        int statusServerError = 500;
        
        System.out.println("\n=== INT Type (Most Important) ===");
        System.out.println("Implicit Wait: " + implicitWaitSeconds + " seconds");
        System.out.println("Page Load Timeout: " + pageLoadTimeout + " seconds");
        System.out.println("Total Test Cases: " + totalTestCases);
        System.out.println("Pass Rate: " + (passedTests * 100 / totalTestCases) + "%");
        System.out.println("Memory Size: 4 bytes per variable");
        
        // Real-world: Dynamic wait calculation
        int baseWait = 10;
        int additionalWait = 5;
        int calculatedWait = baseWait + additionalWait;
        System.out.println("Calculated Wait: " + calculatedWait + " seconds");
    }
    
    /**
     * LONG - 64 bits (8 bytes)
     * Range: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
     * 
     * AUTOMATION USE CASES:
     * ✅ Timestamps (System.currentTimeMillis())
     * ✅ Test execution duration
     * ✅ Unique test IDs
     * ✅ Database record IDs
     * ✅ File sizes
     */
    public void demonstrateLong() {
        // Timestamps - Critical for logging and reporting
        long testStartTime = System.currentTimeMillis();
        
        // Simulate test execution
        try {
            Thread.sleep(2000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long testEndTime = System.currentTimeMillis();
        long executionDuration = testEndTime - testStartTime;
        
        // Large IDs from database
        long userId = 9876543210L; // Note the 'L' suffix for long literals
        long transactionId = 1234567890123456789L;
        
        System.out.println("\n=== LONG Type ===");
        System.out.println("Test Start Time: " + testStartTime);
        System.out.println("Test End Time: " + testEndTime);
        System.out.println("Execution Duration: " + executionDuration + " ms");
        System.out.println("User ID: " + userId);
        System.out.println("Memory Size: 8 bytes per variable");
        
        // Real-world: Generating unique test execution ID
        String testExecutionId = "TEST_" + System.currentTimeMillis();
        System.out.println("Unique Test ID: " + testExecutionId);
    }
    
    // ============================================================
    // FLOATING-POINT TYPES - Decimal Numbers
    // ============================================================
    
    /**
     * FLOAT - 32 bits (4 bytes)
     * Precision: ~6-7 decimal digits
     * 
     * AUTOMATION USE CASES:
     * ⚠️ Limited use in automation (double preferred)
     * ✅ Page load times (when precision isn't critical)
     * ✅ Performance metrics
     */
    public void demonstrateFloat() {
        float pageLoadTime = 2.5f; // Note the 'f' suffix for float literals
        float apiResponseTime = 1.234f;
        float averageExecutionTime = 45.67f;
        
        System.out.println("\n=== FLOAT Type ===");
        System.out.println("Page Load Time: " + pageLoadTime + " seconds");
        System.out.println("API Response Time: " + apiResponseTime + " seconds");
        System.out.println("Average Execution Time: " + averageExecutionTime + " seconds");
        System.out.println("Memory Size: 4 bytes per variable");
        
        // Warning: Precision issues
        float num1 = 0.1f;
        float num2 = 0.2f;
        float result = num1 + num2;
        System.out.println("0.1 + 0.2 = " + result + " (May not be exactly 0.3!)");
    }
    
    /**
     * DOUBLE - 64 bits (8 bytes) ⭐ PREFERRED for decimals
     * Precision: ~15-16 decimal digits
     * 
     * AUTOMATION USE CASES:
     * ✅ Accurate performance metrics
     * ✅ API response times
     * ✅ Test execution statistics
     * ✅ Financial calculations in test data
     * ✅ Percentage calculations
     */
    public void demonstrateDouble() {
        // Performance metrics
        double accuratePageLoadTime = 2.5678;
        double apiResponseTime = 0.234;
        double totalExecutionTime = 125.456789;
        
        // Statistical calculations
        double passPercentage = 94.66666666666667;
        double avgTestDuration = 45.234;
        
        // Financial test data
        double productPrice = 1299.99;
        double discount = 0.15; // 15%
        double finalPrice = productPrice * (1 - discount);
        
        System.out.println("\n=== DOUBLE Type (Preferred for Decimals) ===");
        System.out.println("Accurate Page Load: " + accuratePageLoadTime + " seconds");
        System.out.println("API Response: " + apiResponseTime + " seconds");
        System.out.println("Pass Percentage: " + passPercentage + "%");
        System.out.println("Product Price: $" + productPrice);
        System.out.println("Final Price (15% off): $" + finalPrice);
        System.out.println("Memory Size: 8 bytes per variable");
        
        // Real-world: Calculate pass rate with precision
        int totalTests = 150;
        int passedTests = 142;
        double passRate = (double) passedTests / totalTests * 100;
        System.out.printf("Precise Pass Rate: %.2f%%\n", passRate);
    }
    
    // ============================================================
    // CHARACTER TYPE - Single Character
    // ============================================================
    
    /**
     * CHAR - 16 bits (2 bytes)
     * Range: 0 to 65,535 (Unicode characters)
     * 
     * AUTOMATION USE CASES:
     * ✅ Single character inputs
     * ✅ Status flags ('P'=Pass, 'F'=Fail)
     * ✅ Environment codes ('D'=Dev, 'Q'=QA, 'S'=Staging, 'P'=Prod)
     * ✅ Special characters in test data
     */
    public void demonstrateChar() {
        // Environment identifiers
        char devEnvironment = 'D';
        char qaEnvironment = 'Q';
        char stagingEnvironment = 'S';
        char prodEnvironment = 'P';
        
        // Test status flags
        char passStatus = 'P';
        char failStatus = 'F';
        char skipStatus = 'S';
        
        // Special characters for test data
        char atSymbol = '@';
        char dollarSign = '$';
        char percentSign = '%';
        
        System.out.println("\n=== CHAR Type ===");
        System.out.println("Environment: " + qaEnvironment + " (QA)");
        System.out.println("Test Status: " + passStatus + " (Pass)");
        System.out.println("Email symbol: " + atSymbol);
        System.out.println("Memory Size: 2 bytes per variable");
        
        // Unicode characters
        char copyrightSymbol = '\u00A9'; // ©
        char euroSymbol = '\u20AC'; // €
        System.out.println("Copyright: " + copyrightSymbol);
        System.out.println("Euro: " + euroSymbol);
        
        // Real-world: Environment-based configuration
        char currentEnv = 'Q';
        String envName = getEnvironmentName(currentEnv);
        System.out.println("Running tests in: " + envName);
    }
    
    /**
     * Helper method for environment name
     */
    private String getEnvironmentName(char envCode) {
        switch (envCode) {
            case 'D': return "Development";
            case 'Q': return "QA";
            case 'S': return "Staging";
            case 'P': return "Production";
            default: return "Unknown";
        }
    }
    
    // ============================================================
    // BOOLEAN TYPE - True/False
    // ============================================================
    
    /**
     * BOOLEAN - 1 bit (but JVM uses 1 byte)
     * Values: true or false
     * 
     * AUTOMATION USE CASES: ⭐ EXTREMELY IMPORTANT
     * ✅ Test pass/fail status
     * ✅ Element visibility checks
     * ✅ Feature flags
     * ✅ Configuration toggles
     * ✅ Conditional test execution
     * ✅ Assertion results
     */
    public void demonstrateBoolean() {
        // Test execution flags
        boolean runSmokeTests = true;
        boolean runRegressionTests = false;
        boolean isParallelExecution = true;
        boolean takeScreenshotOnFailure = true;
        
        // Element state checks (like Selenium)
        boolean isElementVisible = true;
        boolean isElementEnabled = true;
        boolean isElementSelected = false;
        
        // Test results
        boolean isTestPassed = true;
        boolean isTestSkipped = false;
        
        // Environment configurations
        boolean isProductionEnvironment = false;
        boolean debugMode = true;
        
        System.out.println("\n=== BOOLEAN Type (Critical for Automation) ===");
        System.out.println("Run Smoke Tests: " + runSmokeTests);
        System.out.println("Parallel Execution: " + isParallelExecution);
        System.out.println("Element Visible: " + isElementVisible);
        System.out.println("Test Passed: " + isTestPassed);
        System.out.println("Debug Mode: " + debugMode);
        System.out.println("Memory Size: 1 byte (though logically 1 bit)");
        
        // Real-world: Conditional test execution
        if (runSmokeTests) {
            System.out.println("Executing smoke test suite...");
        }
        
        if (isTestPassed && takeScreenshotOnFailure == false) {
            System.out.println("Test passed - no screenshot needed");
        }
        
        // Real-world: Element interaction logic
        if (isElementVisible && isElementEnabled) {
            System.out.println("Element is ready for interaction");
        } else {
            System.out.println("Element is not ready - applying wait strategy");
        }
    }
    
    // ============================================================
    // COMPARISON & SIZE DEMONSTRATION
    // ============================================================
    
    /**
     * Compare all primitive types - Memory & Range
     */
    public void compareAllPrimitives() {
        System.out.println("\n=== PRIMITIVE TYPES COMPARISON ===");
        System.out.println("┌─────────┬──────────┬─────────────────────────────────────────┐");
        System.out.println("│ Type    │ Size     │ Range                                   │");
        System.out.println("├─────────┼──────────┼─────────────────────────────────────────┤");
        System.out.println("│ byte    │ 1 byte   │ -128 to 127                             │");
        System.out.println("│ short   │ 2 bytes  │ -32,768 to 32,767                       │");
        System.out.println("│ int     │ 4 bytes  │ -2,147,483,648 to 2,147,483,647         │");
        System.out.println("│ long    │ 8 bytes  │ -9.2E18 to 9.2E18                       │");
        System.out.println("│ float   │ 4 bytes  │ ~6-7 decimal digits precision           │");
        System.out.println("│ double  │ 8 bytes  │ ~15-16 decimal digits precision         │");
        System.out.println("│ char    │ 2 bytes  │ 0 to 65,535 (Unicode)                   │");
        System.out.println("│ boolean │ 1 byte   │ true or false                           │");
        System.out.println("└─────────┴──────────┴─────────────────────────────────────────┘");
        
        System.out.println("\n⭐ AUTOMATION PRIORITIES:");
        System.out.println("1. INT     - 90% of number usage (timeouts, counts, IDs)");
        System.out.println("2. BOOLEAN - Essential for conditions & flags");
        System.out.println("3. LONG    - Timestamps & large IDs");
        System.out.println("4. DOUBLE  - Precise decimal calculations");
        System.out.println("5. CHAR    - Limited use (flags, single chars)");
        System.out.println("6. Others  - Rare in modern automation");
    }
    
    // ============================================================
    // MAIN METHOD - Execute All Demonstrations
    // ============================================================
    
    public static void main(String[] args) {
        PrimitiveDataTypes demo = new PrimitiveDataTypes();
        
        demo.demonstrateByte();
        demo.demonstrateShort();
        demo.demonstrateInt();
        demo.demonstrateLong();
        demo.demonstrateFloat();
        demo.demonstrateDouble();
        demo.demonstrateChar();
        demo.demonstrateBoolean();
        demo.compareAllPrimitives();
        
        System.out.println("\n========================================");
        System.out.println("Day 2 - Primitive Data Types Complete!");
        System.out.println("========================================");
    }
}