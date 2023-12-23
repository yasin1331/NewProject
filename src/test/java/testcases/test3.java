package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class test3 extends Base {
	public WebDriver driver;
	@Test
	public void testthree() throws IOException, InterruptedException {

		System.out.println("test3 executed");
		 driver = intializeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		driver.close();
	}

}
