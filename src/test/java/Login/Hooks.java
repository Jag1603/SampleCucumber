package Login;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverFactory.getDriver();
        ExtentReportListener.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ExtentReportListener.logFail("Scenario failed: " + scenario.getName());
        }
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        DriverFactory.quitDriver();
        ExtentReportListener.flush();
    }
}
