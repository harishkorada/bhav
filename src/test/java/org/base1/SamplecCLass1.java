package org.base1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SamplecCLass1 extends BaseSample {
	public static void main(String[] args) throws InterruptedException {
		BaseSample li=new BaseSample();
		li.get("chrome");
		li.launchUrl("https://adactinhotelapp.com/");
		Thread.sleep(3000);
		WebElement typfirstname = li.locators("id", "username");
		li.type(typfirstname, "8985813898");
		WebElement typpass = li.locators("id", "password");
		li.type(typpass, "LP869X");
		li.locators("id", "login").click();
		//driver.quit();
	//	WebElement locators = li.locators("id", "location");
		//Select select=new Select(locators);
		//select.selectByIndex(6);
		//WebElement locators2 = li.locators("id", "hotels");
		//Select select2=new Select(locators2);
		//select2.selectByIndex(4);
		//WebElement locators3 = li.locators("id", "room_nos");
		//Select select3=new Select(locators3);
		//select3.selectByIndex(4);
		
		
		
		
		
		
		
		
		
		
		
	}

}
