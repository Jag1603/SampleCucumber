package Login;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener {
    private static final ExtentReports EXTENT_REPORTS = new ExtentReports();
    private static final Map<String, ExtentTest> TEST_MAP = new HashMap<>();

    static {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-reports/ExtentSpark.html");
        EXTENT_REPORTS.attachReporter(spark);
    }

    public static void createTest(String scenarioName) {
        ExtentTest test = EXTENT_REPORTS.createTest(scenarioName);
        TEST_MAP.put(Thread.currentThread().getName(), test);
    }

    public static void logInfo(String message) {
        getCurrentTest().info(message);
    }

    public static void logPass(String message) {
        getCurrentTest().pass(message);
    }

    public static void logFail(String message) {
        getCurrentTest().fail(message);
    }

    public static void flush() {
        EXTENT_REPORTS.flush();
    }

    private static ExtentTest getCurrentTest() {
        return TEST_MAP.get(Thread.currentThread().getName());
    }
}
