package org.base1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excell5 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			File file=new File("C:\\Users\\HARISH\\eclipse-workspace\\MavenExcell6\\excelldata1\\Book1.xlsx");  
			FileInputStream stream=new FileInputStream(file);
			Workbook workbook=new XSSFWorkbook(stream);
			//create asheet
			Sheet createSheet = workbook.createSheet("sheet4");
			//iterate
			for (int i = 0; i <list.size(); i++) {
				WebElement element = list.get(i);
				String text = element.getText();
				System.out.println(text);
				
				Row row = createSheet.createRow(i);
				Cell createCell = row.createCell(0);
				
				createCell.setCellValue(text);
			}
			FileOutputStream stream2=new FileOutputStream(file);
			workbook.write(stream2);
			
			
			
			
			
			
		}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
			
		
		
		
	
	
	



