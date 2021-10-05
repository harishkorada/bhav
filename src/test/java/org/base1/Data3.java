package org.base1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data3 {
	@DataProvider(name="excelldata")
			private Object[][] getData() throws IOException {
	File file=new File("C:\\Users\\HARISH\\eclipse-workspace\\MavenExcell6\\EXCELL9\\BOOK2.xlsx");
	FileInputStream inputStream=new FileInputStream(file);
	Workbook workbook=new XSSFWorkbook(inputStream);
	Sheet sheet = workbook.getSheet("facebook");
	Row row = sheet.getRow(0);
	int Rows = sheet.getPhysicalNumberOfRows();
	int cells = row.getLastCellNum();
	Object data[][]=new Object[Rows-1][cells];
	for (int i = 0; i <Rows-1; i++) {
		Row row2 = sheet.getRow(i+1);
		for (int j = 0; j < cells; j++) {
			Cell cell = row2.getCell(j);
			DataFormatter dataFormatter=new  DataFormatter();
			String formatCellValue = dataFormatter.formatCellValue(cell);
			data[i][j]= formatCellValue;
		}
	}
	return data;
			
		}
@Test(dataProvider="excelldata") 
private void tc(String s,String s1) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.facebook.com/");
WebElement element = driver.findElement(By.id("email"));
element.sendKeys(s);
WebElement element2 = driver.findElement(By.id("pass"));
element2.sendKeys(s1);
}
}
	
	
	
	
	
	
	
	
	
	



		
	






