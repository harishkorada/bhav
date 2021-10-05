package org.base1;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameters45 {  
	static WebDriver driver;
	@BeforeClass
	private void beforeclass() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
		}
	@BeforeMethod
	private void beforemethod() {
		Date date=new Date();
		System.out.println(date);

	}
	@Parameters({"hari"})
	@Test(priority=0)
	private void tc1(String s) {
		WebElement element = driver.findElement(By.id("username"));
		element.sendKeys(s);
		}
	@Parameters({"pass"})
	@Test(priority=1)
	private void tc3(String s1) {
	  WebElement element1 = driver.findElement(By.id("password"));
	  element1.sendKeys(s1);
	  Thread.currentThread().getId();
	   }
	
	@Test(priority=2)
	private void tc5() {
		WebElement btnlogin = driver.findElement(By.id("login"));
		btnlogin.click();
}
	
	}


