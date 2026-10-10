package Login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        ExtentReportListener.createTest("Scenario: " + Thread.currentThread().getName());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        DriverFactory.quitDriver();
        ExtentReportListener.flush();
    }
}
