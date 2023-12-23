package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class test2 extends Base {
	public WebDriver driver;

	@Test
	public void testtwo() throws IOException, InterruptedException {
		System.out.println("this script is updated by the Anas");
		System.out.println("this script is updated by Asqhi");
		System.out.println("this script is updated by Ateeq");
		System.out.println("test 2 executed");
		driver = intializeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		Assert.assertTrue(false);

	}
@AfterMethod
	public void closure() {
		driver.close();
	}
}
