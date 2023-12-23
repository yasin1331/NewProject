package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement emailaddress;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(css = "input[value='Login']")
	private WebElement loginbutton;  //using encapsulation in pom

	public WebElement emailaddress() {
		return emailaddress;
	}

	public WebElement password() {
		return password;
	}

	public WebElement loginbutton() {
		return loginbutton;
	}
}
