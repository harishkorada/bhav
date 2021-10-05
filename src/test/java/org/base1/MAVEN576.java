package org.base1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
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

public class MAVEN576 {
	@DataProvider(name= "excell data")
	public Object[][] getData() throws IOException {
	File file=new File("C:\\Users\\HARISH\\eclipse-workspace\\MavenExcell6\\EXCELL9\\BOOK2.xlsx");
	FileInputStream stream=new FileInputStream(file);
	Workbook workbook=new XSSFWorkbook();
	Sheet sheet = workbook.getSheet("sheet1");
	Row row = sheet.getRow(0);
	int rows = sheet.getPhysicalNumberOfRows();
	int s = row.getLastCellNum();
	Object data[][]=new  Object[rows-1][s];
	for (int i = 0; i < rows-1; i++) {
		Row row2 = sheet.getRow(i);
		for (int j = 0; j <s; j++) {
			Cell cell = row2.getCell(j);
			DataFormatter formatter=new DataFormatter();
			String cellValue = formatter.formatCellValue(cell);
			
		}
	}
	return data;
}
@Test(dataProvider="excell data")
private void tc1(String s,String s1) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	WebElement element = driver.findElement(By.id("email"));
	element.sendKeys(s);
	WebElement element2 = driver.findElement(By.id("pass"));
	element2.sendKeys(s1);

	
}
}



	




