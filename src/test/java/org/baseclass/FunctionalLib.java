
package org.baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;
import javax.xml.transform.Source;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalLib {
	public static WebDriver driver;
	public static void getDriver( String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if (browsername.equalsIgnoreCase("InternetExplorer")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else {
			System.out.println("invalid browser");
		}
			
		driver.manage().window().maximize();
	
	}
	
	//1
	public  static void launchUrl(String url) {
		driver.get(url);
	}//2
	public String currentUrl() {
		String currentUrl=driver.getCurrentUrl();
		return currentUrl;
	}//3
	public String title() {
		String title= driver.getTitle();
		return title;
	}//4
	public void close() {
		driver.close();

	}//5
	public void quit() {
		driver.quit();

	}//6
	public String windowHandle() {
		String parentId = driver.getWindowHandle();
		return parentId;
	}//7
	public void windowHandles() {
		Set<String>allwindowId = driver.getWindowHandles();
		
	}//8
	public void navigation(String url) {
		driver.navigate().to(url);

	}//9
	public void navigateForward() {
		driver.navigate().forward();

	}//10
	public void navigateback() {
		driver.navigate().back();

	}//11
	public void navigateRefresh() {
		driver.navigate().refresh();

	}//12
	public void switchWindowid(String id) {
		driver.switchTo().window(id);

	}//13
	public void switchwindowtitle(String title) {
		driver.switchTo().window(title);

	}//14
	public void switchwindowurl(String url) {
		driver.switchTo().window(url);

	}//15
	public void clear(WebElement element) {
		element.clear();

	}//16
	public void click(WebElement element) {
		element.click();

	}//17
	public String attribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}//18
	public String text(WebElement element) {
		String text = element.getText();
		return text;
	}//19sendkeys 
	public static void passtxt(WebElement element,String text) {
		element.sendKeys(text);

	}//20
	public void moveelement(WebElement element) {
		
		 Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
		
	}//21
	public void actionclick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.click(element).perform();
	}//22
	public void rightclick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}//23
	public void doubleClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}//24
	public void dragdrop(WebElement source,WebElement target) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}//25
	public void dragdrop2(WebElement source,WebElement target) {
		Actions actions=new Actions(driver);
		actions.clickAndHold(source).moveToElement(target).release().perform();
	}//26
	public void actionstxtsend(WebElement element,String txt) {
		Actions actions=new Actions(driver);
		actions.sendKeys(element,txt).perform();
	}//27
	public void keyUp(WebElement element) {
		Actions actions=new Actions(driver);
		actions.keyUp(element,Keys.SHIFT).perform();
	}//28
	public void keyDown(WebElement element) {
		Actions actions=new Actions(driver);
		actions.keyDown(element,Keys.SHIFT).perform();
}//29
	public void accept() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	
		}//30
	public void dismiss() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	
		}//31
		public String  alertgetText() {
			Alert alert=driver.switchTo().alert();
		String text = alert.getText();	
		return text;
	
	}//31
	public void alertsendkeys(String passtxt) {
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(passtxt);

	}//32
	public void scrollDown(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		

	}//33
	public void scrollUp(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}//34
	
	public void jsSendkeys(WebElement element,String data) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
	}//35
	public void jsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);

	}//36
		public void jsgetAttribute(WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			//return type is object but type casting for String
			String executeScript =(String) js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(executeScript);
		
		}//37
		public void getScreenShot(String path) throws IOException {
			TakesScreenshot tk=(TakesScreenshot)driver;
			File source = tk.getScreenshotAs(OutputType.FILE);
			System.out.println(source);
			File des=new File(path);
			FileUtils.copyFile(source, des);
			
		}//38
		public static  void switchFrameid( String locator,String idname) {
			if (locator.equalsIgnoreCase("id")) {
				driver.switchTo().frame(idname);
			}
			else if (locator.equalsIgnoreCase("name")) {
				driver.switchTo().frame(idname);
			}
			
				
			
		}//39
		
		public void switchFrameindex( int index) {
			driver.switchTo().frame(index);
			
		}//40
			public void switchFrameelement(WebElement element) {
				driver.switchTo().frame(element);

			}//41
			public void defaultContent() {
				driver.switchTo().defaultContent();

			}//42
			public void parentFrame() {
				driver.switchTo().parentFrame();
			}//43
			public void SelectBy(WebElement element,String type,String value) {
				Select select=new Select(element);
				if (type.equalsIgnoreCase("index")) {
					select.selectByIndex(Integer.parseInt(value));
				}
				else if (type.equalsIgnoreCase("value")) {
					select.selectByValue(value);
				}
				else if (type.equalsIgnoreCase("text")) {
					select.selectByVisibleText(value);
				}
			}
			//44
			
			public void deSelectBy(WebElement element,String type,String value) {
				Select select=new Select(element);
				if (type.equalsIgnoreCase("index")) {
					select.deselectByIndex(Integer.parseInt(value));
				}
				else if (type.equalsIgnoreCase("value")) {
					select.deselectByValue(value);
				}
				else if (type.equalsIgnoreCase("text")) {
					select.deselectByVisibleText(value);
				}
			}
			//45
			public void deselectAll(WebElement element) {
				Select select=new Select(element);
				select.deselectAll();
			}//46
			public WebElement getFirstSelect(WebElement element) {
				Select select=new Select(element);
				WebElement selectedOption = select.getFirstSelectedOption();
				
				return selectedOption;
			}
			//47
			public List<WebElement>getAllSelected(WebElement element) {
				Select select=new Select(element);
				List<WebElement>allSelectedOptions = select.getAllSelectedOptions();
				
				return allSelectedOptions;

			}
			//48
			public List<WebElement>getoptions(WebElement element) {
				Select select=new Select(element);
				List<WebElement> options = select.getOptions();
				return options;
			}//49
			public boolean isMultiple(WebElement element) {
				Select select=new Select(element);
				boolean multiple = select.isMultiple();
				return multiple;
			}
			//50
			//to locate the element 
			public  WebElement locaters(String locater,String value) {
				WebElement element=null;
				if (locater.equalsIgnoreCase("id")) {
					 element = driver.findElement(By.id(value));
				}
				else if (locater.equalsIgnoreCase("name")) {
					 element = driver.findElement(By.name(value));
				}
				else if (locater.equalsIgnoreCase("xpath")) {
					 element = driver.findElement(By.xpath(value));
				}
					
				else if (locater.equalsIgnoreCase("tagname")) {
					 element = driver.findElement(By.tagName(value));
				}
				return element;
			}
			
			public   static String getExcel(String pathname,String Sheetname,int rowno,int cellno) throws IOException {
				String value="";
				File file=new File(pathname);
				FileInputStream stream=new FileInputStream(file);
				
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(Sheetname);
				Row row = sheet.getRow(rowno);
				Cell cell = row.getCell(cellno);
				int cellType = cell.getCellType();
				if (cellType==1) {
					 value = cell.getStringCellValue();	
				}
				else if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY");
					value = dateFormat.format(dateCellValue);
					
					
				}
				else {
					double numericCellValue = cell.getNumericCellValue();
					long l=(long) numericCellValue;
					 value = String.valueOf(l);
					
				}
				return value;
			
			}
			public static void implicityWait() {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				

			}
			public static void excelWrite(String pathname, String Sheetno,int rowno,int cellno,String data) throws IOException {
				File file=new File(pathname);
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet createSheet = workbook.createSheet(Sheetno);
				Row createRow = createSheet.createRow(rowno);
				Cell createCell = createRow.createCell(cellno);
				createCell.setCellValue(data);
				
				FileOutputStream stream2=new FileOutputStream(file);
				workbook.write(stream2);
				

			}
		}
	
	
	
	
	
