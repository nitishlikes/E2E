package academy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class*='video-banner'] h3")
	private WebElement head;

	@FindBy(css = "a[href*='sign_in']")
	private WebElement signin;

	@FindBy(xpath = "//div[@class='text-center']/h2")
	private WebElement title;

	@FindBy(css = ".nav.navbar-nav.navbar-right")
	private WebElement bar;

	public Login login() {
		signin.click();
		Login l = new Login(driver);
		return l;

	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement header() {
		return bar;
	}

	public WebElement getHeader() {
		return head;
	}
}
