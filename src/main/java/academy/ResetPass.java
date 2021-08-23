package academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPass {

	WebDriver driver;

	public ResetPass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	private WebElement email;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement instruct;

	public WebElement reset() {
		return email;
	}

	public WebElement instructions() {
		return instruct;
	}
}
