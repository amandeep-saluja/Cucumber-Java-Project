package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SeleniumConstants;

/**
 * Google Form Step definition class
 *
 */
public class GoogleFormSteps {

	WebDriver driver = null;

	public By NAME_FIELD = By
			.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input");

	public By DOB_FIELD = By.cssSelector(
			"#mG61Hd > div.freebirdFormviewerViewFormCard.exportFormCard > div > div.freebirdFormviewerViewItemList > div:nth-child(2) > div > div > div:nth-child(2) > div > div > div.quantumWizTextinputPaperinputEl.freebirdThemedInput.freebirdFormviewerComponentsQuestionDateDateInput.modeLight > div.quantumWizTextinputPaperinputMainContent.exportContent > div > div.quantumWizTextinputPaperinputInputArea > input");
//			By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div[1]/input");

	public By ADDRESS_FIELD = By.cssSelector("#mG61Hd > div.freebirdFormviewerViewFormCard.exportFormCard > div > div.freebirdFormviewerViewItemList > div:nth-child(3) > div > div > div.freebirdFormviewerComponentsQuestionTextRoot > div > div.quantumWizTextinputPapertextareaMainContent.exportContent > div.quantumWizTextinputPapertextareaContentArea.exportContentArea > textarea");
//			By.xpath("//*[@id=\"SchemaEditor\"]/div/div[2]/div/div[2]/div[3]/div[3]/div/div/div[1]/div[2]/div[3]/div[1]/div[2]/div/div[1]/div/div[2]/input");

	public By MALE_GENDER_FIELD = By.cssSelector("#i21 > div.appsMaterialWizToggleRadiogroupRadioButtonContainer > div"); 
//			By.xpath("//*[@id=\"SchemaEditor\"]/div/div[2]/div/div[2]/div[3]/div[4]/div/div/div[1]/div[2]/div[3]/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div/span/div/div/div[1]/input");

	public By PHONE_NUMBER = By.cssSelector("#mG61Hd > div.freebirdFormviewerViewFormCard.exportFormCard > div > div.freebirdFormviewerViewItemList > div:nth-child(5) > div > div > div.freebirdFormviewerComponentsQuestionTextRoot > div > div.quantumWizTextinputPaperinputMainContent.exportContent > div > div.quantumWizTextinputPaperinputInputArea > input"); 
//			By.xpath("//*[@id=\"SchemaEditor\"]/div/div[2]/div/div[2]/div[3]/div[5]/div/div/div[1]/div[2]/div[3]/div[1]/div[2]/div/div[2]/div/div[2]/input");

	public By COMMENTS_FIELD = By.cssSelector("#mG61Hd > div.freebirdFormviewerViewFormCard.exportFormCard > div > div.freebirdFormviewerViewItemList > div:nth-child(6) > div > div > div.freebirdFormviewerComponentsQuestionTextRoot > div > div.quantumWizTextinputPapertextareaMainContent.exportContent > div.quantumWizTextinputPapertextareaContentArea.exportContentArea > textarea"); 
//	By.xpath("//*[@id=\"SchemaEditor\"]/div/div[2]/div/div[2]/div[3]/div[6]/div/div/div[1]/div[2]/div[3]/div[1]/div[2]/div/div[1]/div/div[2]/input");

	public By SUBMIT_BUTTON = By.cssSelector("#mG61Hd > div.freebirdFormviewerViewFormCard.exportFormCard > div > div.freebirdFormviewerViewNavigationNavControls > div.freebirdFormviewerViewNavigationButtonsAndProgress.hasClearButton > div.freebirdFormviewerViewNavigationLeftButtons > div > span"); 
//			By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div[1]/div[1]/div/span");
	
	public By RESPONSE_MSG = By.cssSelector("body > div.freebirdFormviewerViewFormContentWrapper > div:nth-child(2) > div.freebirdFormviewerViewFormCard.exportFormCard > div > div.freebirdFormviewerViewResponseConfirmationMessage");

	@Given("^user is navigating to (.*) google form page$")
	public void userIsNavigatingToGoogleFormPage(String url) {
		driver = SeleniumConstants.driver;
		driver.navigate().to(url);
	}

	@When("^user is viewing google form$")
	public void userIsViewing() {
		Assert.assertTrue("Url is not correct", driver.getCurrentUrl().contains("https://docs.google.com/forms"));
	}

	@When("^user fills (.*), (.*), (.*), (.*), (.*) and (.*) details$")
	public void userFillsAndDetails(String name, String dob, String address, String gender, String phone,
			String comments) throws InterruptedException {

		WebElement nameElement = SeleniumConstants.fluentWait(NAME_FIELD);
		if (nameElement.isDisplayed()) {
			nameElement.click();
			nameElement.clear();
			nameElement.sendKeys(name);
		} else {
			Assert.assertNotNull(nameElement);
		}

		// DOB
		SeleniumConstants.artificialWait(SeleniumConstants.SHORT);

		WebElement dobElement = SeleniumConstants.fluentWait(DOB_FIELD);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dobElement);
		if (dobElement.isDisplayed()) {
			dobElement.click();
			dobElement.sendKeys(Keys.ARROW_LEFT);
			dobElement.sendKeys(Keys.ARROW_LEFT);
			dobElement.sendKeys("21");
			dobElement.sendKeys("05");
			dobElement.sendKeys(Keys.ARROW_RIGHT);
			dobElement.sendKeys("1990");
		} else {
			Assert.assertNotNull(dobElement);
		}

		// Address
		SeleniumConstants.artificialWait(SeleniumConstants.SHORT);

		WebElement addressElement = SeleniumConstants.fluentWait(ADDRESS_FIELD);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addressElement);
		if (addressElement.isDisplayed()) {
			addressElement.click();
			addressElement.sendKeys(address);
		} else {
			Assert.assertNotNull(addressElement);
		}

		// Gender
		SeleniumConstants.artificialWait(SeleniumConstants.SHORT);

		WebElement genderElement = SeleniumConstants.fluentWait(MALE_GENDER_FIELD);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", genderElement);
		if (genderElement.isDisplayed()) {
			genderElement.click();
		} else {
			Assert.assertNotNull(genderElement);
		}

		// Phone
		SeleniumConstants.artificialWait(SeleniumConstants.SHORT);

		WebElement phoneElement = SeleniumConstants.fluentWait(PHONE_NUMBER);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", phoneElement);
		if (phoneElement.isDisplayed()) {
			phoneElement.click();
			phoneElement.sendKeys(phone);
		} else {
			Assert.assertNotNull(phoneElement);
		}

		// Comments
		SeleniumConstants.artificialWait(SeleniumConstants.SHORT);

		WebElement commentsElement = SeleniumConstants.fluentWait(COMMENTS_FIELD);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", commentsElement);
		if (commentsElement.isDisplayed()) {
			commentsElement.click();
			commentsElement.sendKeys(comments);
		} else {
			Assert.assertNotNull(commentsElement);
		}
	}

	@Then("^user clicks on submit button$")
	public void userClicksOnSubmitButton() throws InterruptedException {
		WebElement submitButtonElement = SeleniumConstants.fluentWait(SUBMIT_BUTTON);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submitButtonElement);
		SeleniumConstants.artificialWait(SeleniumConstants.SHORT);
		if (submitButtonElement.isDisplayed() && submitButtonElement.isEnabled()) {
			submitButtonElement.click();
		} else {
			Assert.assertTrue("Button is not enabled or displayed",
					submitButtonElement.isDisplayed() || submitButtonElement.isEnabled());
		}
	}

	@And("^response save successfully$")
	public void responseSaveSuccessfully() {
		WebElement response = SeleniumConstants.fluentWait(RESPONSE_MSG);
		Assert.assertNotNull(ExpectedConditions.visibilityOf(response));
		driver.close();
		driver.quit();
	}

}
