import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2 {

	
	public static void main(String[] args) throws Exception {
		try {
			
		LocalTime myObj = LocalTime.now();
	    System.out.println(myObj);
		System.setProperty("webdriver.chrome.driver", "E://WebDriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("driver object created");
		driver.navigate().to("https://freecrm.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(By.xpath("//li[@class='active']/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(8000));
		setcredentials(driver,"//input[@name='email']","praveendev404@gmail.com");
		setcredentials(driver,"//input[@name='password']","Test1111$");
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("praveendev404@gmail.com");
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test1111$");
		driver.findElement(By.xpath("//div[contains(@class, 'submit') and contains(., 'Login')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.findElement(By.xpath("//a[contains(@href,'home')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.findElement(By.xpath("//a[contains(@href,'calendar')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.findElement(By.xpath("//a[contains(@href,'calendar/new')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Time Sheet");
		driver.findElement(By.xpath("//div[@class='ui field' and contains (., 'Description')]/textarea")).sendKeys("Updated New Calender");
		driver.findElement(By.xpath("//div[@class='ui field' and contains (., 'Location')]/textarea")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//div[@class='ui field' and contains (., 'Reminder Time')]/div[@class='ui input']/input")).sendKeys("40");
		driver.findElement(By.xpath("//div[@class='ui field' and contains (., 'Identifier')]/div[@class='ui input']/input")).sendKeys("Time Sheet");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
		Date date = new Date();
		takeSnapShot(driver, "C://Users//Admin//Desktop//Selenium//Evidence//"+dateFormat.format(date)+".png");
		LocalTime myObj3 = LocalTime.now();
	    System.out.println(myObj3);
		}
		catch(Exception exe) {}
		}
	
		public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
	public static void setcredentials(WebDriver webdriver,String xpath,String value) 
	{
		
		 webdriver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	



	}


