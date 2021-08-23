package academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".link-below-button")
	private WebElement forgot;

	@FindBy(xpath = "//*[@type='email']")
	private WebElement  email;

	@FindBy(id = "user_password")
	private WebElement password;

	@FindBy(css = "input[type='submit']")
	private WebElement submit;

	public ResetPass forgotPass() {
		forgot.click();
		return new ResetPass(driver);
	}

	public WebElement emaidid() {
		return email;
	}

	public WebElement pass() {
		return password;
	}

	public WebElement submit() {
		return submit;
	}
}
