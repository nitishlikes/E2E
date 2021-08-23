package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseClass;

public class Title extends BaseClass {
	public WebDriver driver;
	LoginPage lp;
	public static Logger log = LogManager.getLogger(Title.class.getName());

	@Test
	public void validateTitle() throws IOException {
		lp = new LoginPage(driver);
		String actual = lp.getTitle().getText();
		Assert.assertEquals(actual, "FEATURED COURSES");
		Assert.assertTrue(lp.header().isDisplayed());
		log.info("Validation Successful");
	}

	@Test
	public void validateHeader() {
		lp = new LoginPage(driver);
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

	@BeforeTest
	public void first() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initailized");
		driver.manage().window().maximize();
		log.info("Window Maximized");
		driver.get(p.getProperty("Url"));
		log.info("Navigated to Home Page");

	}

	@AfterTest
	public void last() {
		driver.close();
		log.info("Driver Closed");
	}
}
