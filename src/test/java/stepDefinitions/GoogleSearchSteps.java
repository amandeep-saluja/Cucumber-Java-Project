package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SeleniumConstants;

public class GoogleSearchSteps {

	WebDriver driver = null;

	By SEARCH_BOX = By.cssSelector(
			"body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input");

	@Given("browser is open")
	public void browserIsOpen() {
		driver = SeleniumConstants.driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void userIsOnGoogleSearchPage() {
		driver.navigate().to("https://www.google.com/");
	}

	@When("user enters a text in search box")
	public void userEntersATextInSearchBox() {
		WebElement element = driver.findElement(SEARCH_BOX);
		element.click();
		element.clear();
		element.sendKeys("selenium cucumber");
	}

	@And("hits enter")
	public void hitsEnter() {
		WebElement element = driver.findElement(SEARCH_BOX);
		element.sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search results")
	public void userIsNavigatedToSearchResults() {
		WebElement element = driver.findElement(By.id("search"));
		Assert.assertNotNull(element);
	}
}
