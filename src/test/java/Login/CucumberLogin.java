package Login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberLogin 
{

	
	@Given("user is on login page")
	public void user_is_on_login_page()
	{
	    System.out.println("Test 1");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() 
	{
		System.out.println("Test 2");
	}

	@When("user clicks submit button")
	public void user_clicks_submit_button() 
	{
		System.out.println("Test 3");
	}

	@Then("user should be to login succesfully")
	public void user_should_be_to_login_succesfully() 
	{
		System.out.println("Test 4");
	}


}
