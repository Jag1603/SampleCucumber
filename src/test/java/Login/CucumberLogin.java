package Login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberLogin {

    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private String username;
    private String password;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.open();
        assertTrue(loginPage.isLoginPageLoaded(), "Login page is not loaded successfully.");
        ExtentReportListener.logInfo("User navigated to login page.");
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        this.username = username;
        this.password = password;
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        ExtentReportListener.logInfo("Entered credentials for user: " + username);
    }

    @When("user clicks submit button")
    public void user_clicks_submit_button() {
        loginPage.clickLogin();
        ExtentReportListener.logInfo("Clicked login button.");
    }

    @Then("user should be able to login successfully with status {string}")
    public void user_should_be_able_to_login_successfully_with_status(String expectedStatus) {
        if ("success".equalsIgnoreCase(expectedStatus)) {
            assertTrue(loginPage.isLoginSuccessful(), "Expected login to succeed for user: " + username);
            ExtentReportListener.logPass("Login was successful for user: " + username);
        } else {
            assertTrue(loginPage.isErrorDisplayed(), "Expected login failure error message for user: " + username);
            ExtentReportListener.logFail("Login failed as expected for user: " + username + ". Error: " + loginPage.getErrorMessage());
        }
    }
}
