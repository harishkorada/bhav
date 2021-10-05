package org.base1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	WebDriver driver;
	@BeforeClass
	private void beforeclass() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://adactinhotelapp.com/index.php");
		

	}
	@BeforeMethod
	private void before() {
	Date date =new Date();
	System.out.println(date);

	}
	@Parameters({"8985813898"})
	@Test
	private void TE1(String s) {
		WebElement element = driver.findElement(By.id("username"));
		element.sendKeys(s);

	}
	@Parameters({"Harish123"})
	@Test
	private void TE2(String s1) {
		WebElement element1= driver.findElement(By.id("password"));
		element1.sendKeys(s1);

	}
	@Test
	private void te3() {
		WebElement btnlogin= driver.findElement(By.id("login"));
		btnlogin.click();

	}
	@AfterClass
	private void afetm() {
		driver.quit();

	}
	
}

