








package org.base1;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSample {
	public static WebDriver driver;

	public WebDriver get(String browsername) {
		switch (browsername) {
		case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new  EdgeDriver();
			break;
		
default:
	System.out.println("invalid browser");
			break;
		}
		driver.manage().window().maximize();
		return driver;
	}
	public  void pagetitle(String string) {
		driver.get(null);
}
	public void launchUrl(String Url) {
		driver.get(Url);
		}
	public void type(WebElement element1, String value) {
		element1.sendKeys(value);

	}
	public WebElement locators(String locatortype, String locatorvalue) {
		WebElement element = null;
	switch (locatortype) {
	case "id":
		element = driver.findElement(By.id(locatorvalue));
		break;
		
	case "name":
		 element = driver.findElement(By.name(locatorvalue));
		break;
	case "class":
		element = driver.findElement(By.className(locatorvalue));
		break;
	case "xpath":
		element = driver.findElement(By.xpath(locatorvalue));
		break;

	default:
		System.out.println("invalid");
		break;
	}
	return element;
	}
	public void button (WebElement element) {
		element.click();
		
	}
	public void dropoption(WebElement element1, String value, String dropoption) {
		Select select=new Select(element1);
	switch (dropoption) {
	case "index":
		select.selectByIndex(Integer.parseInt(value));
		break;
	case "value":
		select.selectByValue(value);
		break;
	case "visible" :
		select.selectByVisibleText(dropoption);
		break;
	default:
		System.out.println("invalid");
		break;
		}

		
	}

	public void takescreen(String path) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		FileUtils.copyFile(screenshotAs, file);
		
			}
		
	}




				
				
			
		
		
		
	
		

	

	
	

	
	
	
	
		

	
	

	
		

	














