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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excell44 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("countries"));
		Select select=new Select(element);
		List<WebElement> list = select.getOptions();
		//file
		File file=new File("C:\\Users\\HARISH\\eclipse-workspace\\MavenExcell6\\EXCELL9\\BOOK2.xlsx");
		FileInputStream stream =new FileInputStream(file);
	Workbook workbook=new XSSFWorkbook(stream);
	Sheet createSheet = workbook.createSheet("datas");
	Row row = createSheet.createRow(0);
	Cell createCell = row.createCell(0);
	createCell.setCellValue("countries");
	//iterate
	for (int i = 0; i < list.size(); i++) {
		WebElement element2 = list.get(i);
		String text = element2.getText();
		Row createRow = createSheet.createRow(i);
		Cell createCell2 = createRow.createCell(0);
		createCell2.setCellValue(text);
		System.out.println(text);
		
	}
	FileOutputStream stream2 =new FileOutputStream(file);
	workbook.write(stream2);
		
		
	
	
		
		
		
		
	
		
		
		
		
		
	}

}
