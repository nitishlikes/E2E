package academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import resources.BaseClass;

public class HomePage extends BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@Test(dataProvider = "getData")
	public void home(String emailid, String pass) throws IOException {
		driver.get(p.getProperty("Url"));
		LoginPage lp = new LoginPage(driver);
		Login l=lp.login();
		//Login l = new Login(driver);
		l.emaidid().sendKeys(emailid);
		l.pass().sendKeys(pass);
		l.submit().click();
		log.info("Data Sent");
		ResetPass rp=l.forgotPass();
		rp.reset().sendKeys("unknown@gmail.com");
		rp.instructions().click();
	}

	@DataProvider
	public Object[][] getData() {
		Object data[][] = new Object[2][2];
		data[0][0] = "abc@gmail.com";
		data[0][1] = "12345";
		data[1][0] = "xyz@gmail.com";
		data[1][1] = "6789";
		return data;
	}

	@BeforeTest
	public void first() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void last() {
		driver.close();
	}
}
