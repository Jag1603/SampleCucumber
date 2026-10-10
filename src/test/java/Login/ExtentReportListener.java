package Login;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener {
    private static final ExtentReports EXTENT_REPORTS = new ExtentReports();
    private static final ThreadLocal<ExtentTest> CURRENT_TEST = new ThreadLocal<>();

    static {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-reports/ExtentSpark.html");
        EXTENT_REPORTS.attachReporter(spark);
    }

    public static void createTest(String scenarioName) {
        ExtentTest test = EXTENT_REPORTS.createTest(scenarioName);
        CURRENT_TEST.set(test);
    }

    public static void logInfo(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.info(message);
        }
    }

    public static void logPass(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.pass(message);
        }
    }

    public static void logFail(String message) {
        ExtentTest currentTest = getCurrentTest();
        if (currentTest != null) {
            currentTest.fail(message);
        }
    }

    public static void flush() {
        EXTENT_REPORTS.flush();
        CURRENT_TEST.remove();
    }

    private static ExtentTest getCurrentTest() {
        return CURRENT_TEST.get();
    }
}
