package model;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * Class that holds all the selenium constants
 *
 */
public class SeleniumConstants {

	/**
	 * Web driver object
	 */
	public static WebDriver driver;

	/**
	 * Constant for 2 seconds delay
	 */
	public static final Integer Very_SHORT = 2;

	/**
	 * Constant for 5 seconds delay
	 */
	public static final Integer SHORT = 5;

	/**
	 * Constant for 10 seconds delay
	 */
	public static final Integer LONG = 10;

	/**
	 * Constant for 15 seconds delay
	 */
	public static final Integer VERY_LONG = 15;

	static {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static WebElement fluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(2))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return foo;
	}

	public static void artificialWait(Integer delay) {
		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(delay))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
	}
}
