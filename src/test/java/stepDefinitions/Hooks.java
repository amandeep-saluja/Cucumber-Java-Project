package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import model.SeleniumConstants;

public class Hooks {

	WebDriver driver;
	
	@Before
	public void browserSetup() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(SeleniumConstants.SHORT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SeleniumConstants.SHORT));
		driver.manage().window().maximize();
		SeleniumConstants.driver = driver;
	}
	
	@AfterStep
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			// Take screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// Embed it in the report.
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	@After
	public void closeBrowserWindow() {
		driver.quit();
	}
}
