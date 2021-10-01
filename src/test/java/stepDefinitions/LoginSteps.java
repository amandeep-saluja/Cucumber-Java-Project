package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("^user is on login page$")
	public void userIsOnLoginPage() {
		System.out.println("user is on login page");
	}

	@When("^user enters username and password$")
	public void userEntersUsernameAndPassword() {
		System.out.println("user enters username and password");
	}

	@And("^clicks on login button$")
	public void clicksOnLoginButton() {
		System.out.println("clicks on login button");
	}

	@Then("^user is navigated to home page$")
	public void userIsNavigatedToHomePage() {
		System.out.println("user is navigated to home page");
	}
}
