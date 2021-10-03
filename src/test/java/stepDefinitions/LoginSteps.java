package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SeleniumConstants;

public class LoginSteps{

	private WebDriver driver;
	
	@Given("^user is on login page$")
	public void userIsOnLoginPage() {
		driver = SeleniumConstants.driver;
		driver.navigate().to("https://example.testproject.io/web/");
		Assert.assertEquals("Login page not opened", driver.getCurrentUrl(), "https://example.testproject.io/web/");
	}

	@When("^user enters username and password$")
	public void userEntersUsernameAndPassword() {
		WebElement userName = SeleniumConstants.fluentWait(By.id("name"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", userName);
		if(userName.isDisplayed()) {
			userName.click();
			userName.clear();
			userName.sendKeys("Ashish");
		}
		else {
			Assert.assertNotNull("User id field not found", ExpectedConditions.presenceOfElementLocated(By.id("name")));
		}
		
		WebElement password = SeleniumConstants.fluentWait(By.id("password"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", password);
		if(password.isDisplayed()) {
			password.click();
			password.clear();
			password.sendKeys("12345");			
		}
		else {
			Assert.assertNotNull("Password field not found", ExpectedConditions.presenceOfElementLocated(By.id("password")));
		}
	}

	@And("^clicks on login button$")
	public void clicksOnLoginButton() throws InterruptedException {
		Thread.sleep(200);
		WebElement loginBtn = driver.findElement(By.id("login"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", loginBtn);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}

	@Then("^user is navigated to home page$")
	public void userIsNavigatedToHomePage() throws InterruptedException {
		Thread.sleep(200);
		WebElement greetings = SeleniumConstants.fluentWait(By.id("greetings"));
		Assert.assertTrue("Greeting not displayed", greetings.isDisplayed());			
	}
}
