import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class sample {

	public static void main(String[] args) throws Exception {
		LocalTime myObj = LocalTime.now();
	    System.out.println(myObj);
		System.setProperty("webdriver.chrome.driver", "E://WebDriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("driver object created");
		driver.navigate().to("https://freecrm.com");
		Thread.sleep(5000);
		findelementbyxpathandclick(driver,"//li[@class='active']/a");
		Thread.sleep(10000);
		findelementbyxpathandsendkeys(driver,"//input[@name='email']","praveendev404@gmail.com");
		findelementbyxpathandsendkeys(driver,"//input[@name='password']","Test1111$");
		driver.findElement(By.xpath("//div[contains(@class, 'submit') and contains(., 'Login')]")).click();
		Thread.sleep(5000);
		findelementbyxpathandclick(driver,"//a[contains(@href,'home')]");
		Thread.sleep(2000);
		findelementbyxpathandclick(driver,"//a[contains(@href,'calendar')]");
		Thread.sleep(2000);
		findelementbyxpathandclick(driver,"//a[contains(@href,'calendar/new')]");
		Thread.sleep(1000);
		calenderpage(driver);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
		Date date = new Date();
		takeSnapShot(driver, "C://Users//Admin//Desktop//Selenium//Evidence//"+dateFormat.format(date)+".png");
		LocalTime myObj2 = LocalTime.now();
	    System.out.println(myObj2);
	    contactspage(driver);
	}
		private static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		}
		private static void findelementbyxpathandsendkeys(WebDriver webdriver,String xpath,String value) 
		{	
			 webdriver.findElement(By.xpath(xpath)).sendKeys(value);
		}
		
		private static void findelementbyxpathandclick(WebDriver webdriver,String xpath)
		{
			webdriver.findElement(By.xpath(xpath)).click();
		}
		private static void ischecked(WebDriver webdriver, String xpath) 
		{
			WebElement elementdonotcall=webdriver.findElement(By.xpath(xpath)); 
		    ((JavascriptExecutor)webdriver).executeScript(
		    		  "arguments[0].setAttribute('class','ui checked toggle checkbox')", elementdonotcall);
			//webdriver.findElement(By.xpath(xpath)).isSelected();
		}
		private static void calenderpage(WebDriver driver)
		{
			findelementbyxpathandsendkeys(driver,"//input[@name='title']","Time Sheet");
			WebElement elementcategory=driver.findElement(By.xpath("//div[@name='category']/div[contains(@class, 'divider')]")); 
		    ((JavascriptExecutor)driver).executeScript(
		    		  "var ele=arguments[0]; ele.innerHTML = 'Important';", elementcategory);
			findelementbyxpathandsendkeys(driver,"//div[@class='ui field' and contains (., 'Description')]/textarea","Updated New Calender");
			findelementbyxpathandsendkeys(driver,"//div[@class='ui field' and contains (., 'Location')]/textarea","Hyderabad");
			findelementbyxpathandsendkeys(driver,"//div[@class='ui field' and contains (., 'Reminder Time')]/div[@class='ui input']/input","40");
			findelementbyxpathandsendkeys(driver,"//div[@class='ui field' and contains (., 'Identifier')]/div[@class='ui input']/input","Time Sheet");
		}
		private static void contactspage(WebDriver driver)
		{
			findelementbyxpathandclick(driver,"//a[contains(@href,'contacts')]/span");
		    findelementbyxpathandclick(driver,"//a[contains(@href, 'contacts/new')]");
		    findelementbyxpathandsendkeys(driver,"//input[@name='first_name']","Tejasvi");
		    findelementbyxpathandsendkeys(driver,"//input[@name='last_name']","Veerapaneni");
		    findelementbyxpathandsendkeys(driver,"//input[@name='middle_name']","Teju");
		    WebElement btnAccess=driver.findElement(By.xpath("//button[contains(@class, 'positive')]")); //Finding the button and storing in variable
		    String buttontext=btnAccess.getText();
		    if(buttontext!="Private") 
		    {
		    	//User can not select users allowed access
		    	System.out.println("User can not select users allowed access");
		    	btnAccess.click();
		    }
		    else {
		    	//User can select users allowed access
		    	System.out.println("User can select users allowed access");
		    }
			findelementbyxpathandsendkeys(driver,"//input[@placeholder='Email address']","tejasviteju1410@gmail.com");
			findelementbyxpathandsendkeys(driver,"//input[@placeholder='Personal email, Business, Alt...']","vtejasvi2018@gmail.com");
			findelementbyxpathandclick(driver,"//button/i[@class='add icon']");
			WebElement elementcategory1=driver.findElement(By.xpath("//div[@name='category']/div[contains(@class, 'divider')]")); 
		    ((JavascriptExecutor)driver).executeScript(
		    		  "var ele=arguments[0]; ele.innerHTML = 'Lead';", elementcategory1);
		    WebElement elementstatus=driver.findElement(By.xpath("//div[@class='field'][1]/div[@class='ui field']/div[contains(@class,'selection')]/div[contains(@class, 'divider')]")); 
		    ((JavascriptExecutor)driver).executeScript(
		    		  "var ele=arguments[0]; ele.innerHTML = 'Terminated';", elementstatus);
			findelementbyxpathandsendkeys(driver,"//div[@class='ui field' and contains (., 'Description')]/textarea", "Updated New Contacts");
			findelementbyxpathandsendkeys(driver,"//input[@placeholder='Twitter handle']","Tejasvi");
			WebElement elementtimezone=driver.findElement(By.xpath("//div[@name='timezone']/div[contains(@class, 'divider')]")); 
		    ((JavascriptExecutor)driver).executeScript(
		    		  "var ele=arguments[0]; ele.innerHTML = 'Africa/Algiers';", elementtimezone);
			findelementbyxpathandsendkeys(driver,"//input[@placeholder='Street Address']","Orange Street");
			findelementbyxpathandsendkeys(driver,"//input[@placeholder='City']","NY");
			findelementbyxpathandsendkeys(driver,"//input[@placeholder='State / County']","USA");
			findelementbyxpathandsendkeys(driver,"//input[@placeholder='Post Code']","61813");
			findelementbyxpathandsendkeys(driver,"//input[@placeholder='Number']","7243667443");
			findelementbyxpathandsendkeys(driver,"//input[@name='position']","Vice President");
			findelementbyxpathandsendkeys(driver,"//input[@name='department']","IT");
			WebElement elementsource=driver.findElement(By.xpath("//div[@name='source']/div[contains(@class, 'divider')]")); 
		    ((JavascriptExecutor)driver).executeScript(
		    		  "var ele=arguments[0]; ele.innerHTML = 'Website';", elementsource);
			ischecked(driver,"//label[text()='Do not Call']/following-sibling::div");
			findelementbyxpathandsendkeys(driver,"//input[@name='day']","11");
			WebElement elementbirthday=driver.findElement(By.xpath("//div[@name='month']/div[contains(@class, 'divider')]")); 
		    ((JavascriptExecutor)driver).executeScript(
		    		  "var ele=arguments[0]; ele.innerHTML = 'May';", elementbirthday);
		    findelementbyxpathandsendkeys(driver,"//input[@name='year']","91");
		    findelementbyxpathandsendkeys(driver,"//input[@name='identifier']","Test1234");
		    findelementbyxpathandclick(driver,"//div[contains(@class,'item')]/button[@class='ui linkedin button']");
		}
	}

