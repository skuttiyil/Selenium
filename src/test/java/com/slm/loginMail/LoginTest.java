package com.slm.loginMail;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	@Test
	public void f() {
		System.out.println("in test");
		// System.setProperty("webdriver.gecko.driver","C:\\selenium\\drivers\\geckodriver.exe");

		driver.get("https://mail.yahoo.com");
		driver.findElement(By.id("login-username")).sendKeys("xxx@yahoo.com");
		driver.findElement(By.id("login-username-form")).submit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// driver.findElement(By.name("password")).sendKeys("maya");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("yyy");

		WebElement we = driver.findElement(By.xpath("//button[@id='login-signin']"));

		if (we.isEnabled())
			we.click();
		else {

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		String expectedErrorValue = "Invalid password. Please try agaiN";

		WebElement errorElement = driver.findElement(By.className("error-msg"));

		System.out.println("error element " + errorElement.getText());

		/*
		 * if (expectedErrorValue.equalsIgnoreCase(errorElement.getText())) {
		 * assertTrue(true); System.out.println("test case is passed"); } else {
		 * assertTrue(false); System.out.println("test case is failed"); }
		 */

		// assertTrue(expectedErrorValue.equalsIgnoreCase(errorElement.getText()));
		assertEquals(errorElement.getText(), expectedErrorValue, "not equal");

	}

	@Test
	public void sampleTest() {

		driver.get("https://mail.google.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("before class");
	}

	@AfterClass
	public void clearDriver() {
		driver.quit();
	}

}
