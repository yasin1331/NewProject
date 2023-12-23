package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UrlPage {
	WebDriver driver;

	public UrlPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement Myaccountdropdown;

	public WebElement Myaccountdropdown() {
		return Myaccountdropdown;
	}

	@FindBy(linkText = "Login")
	private WebElement loginoption;

	public WebElement loginoption() {
		return loginoption;
	}

}
