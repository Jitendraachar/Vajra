package com.vajra.TestClass;

import java.io.File;
import java.io.IOException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vajra.utilities.Readconfig;
import com.vajra.utilities.XLUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClasss {
	
	// set driver

	// to read the config file using java
	Readconfig readconfig = new Readconfig();
	public String chrome = readconfig.readChrompath();
	public String firefoxpath = readconfig.readFirefoxpath();
	public String envirnoment = readconfig.envirnoment();
	public String Browser=readconfig.readBrowser();
	public static WebDriver driver;
	public static String SalesTittle="Sales - Dashboard - Sales";
	public static String OETittle="";
	// to call different testing environment
	public static String SalesURL;
	public static String OEURL;
	public static String OrderCustomerID="8";
	public static Logger logger;
public static String AlertText;
	@BeforeClass


	public void setup() { 
		driverSetUp();
		envSetUp();
	}
	@AfterClass
	public void tierDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	public void driverSetUp() {	
		if(Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
		}


		else if(Browser.equals("Firefox")) { 
			System.setProperty("webdriver.gecko.driver",readconfig.readFirefoxpath());
			FirefoxOptions options = new FirefoxOptions();

		}
	}
	public void envSetUp() {
		//Setting up envoirment

		if (envirnoment.equals("EXT")) {
			SalesURL = "http://192.168.1.10:2013/Sales";
			OEURL = "http://192.168.1.10:2013/OrderExecution";
		} else if (envirnoment.equals("UAT")) {
			SalesURL = "https://www.google.com/";
			OEURL = "https://www.google.com/";
		} else if (envirnoment.equals("Cloud")) {
			SalesURL = "http://103.1.114.170:2008/Sales";
			OEURL = "http://103.1.114.170:2008/OrderExecution";
		}

	}

	public void captureScreenShot(WebDriver driver,String tname)throws IOException 
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File Src=ts.getScreenshotAs(OutputType.FILE);
		File Trgt=new File(System.getProperty("user.dir")+tname+".png");
		FileUtils.copyFile(Src, Trgt);
	}
	public void waitForElementNotVisible(List<WebElement> allZoneName) {
		try {
			if(isDisplayed((WebElement) allZoneName)) {
				WebDriverWait webDriverWait = new WebDriverWait(driver, readconfig.timeOut());
				webDriverWait.until(ExpectedConditions.invisibilityOf((WebElement) allZoneName));
			}
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	public void waitForElementNotClickable(WebElement elementName) {
		try {
			if(isDisplayed((WebElement) elementName)) {
				WebDriverWait webDriverWait = new WebDriverWait(driver, readconfig.timeOut());
				webDriverWait.until(ExpectedConditions.invisibilityOf((WebElement) elementName));
			}
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	public boolean isDisplayed(WebElement element) {
		try {
			if(element.isDisplayed())
				return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return false;
	}
	public Logger getLogger(String ClassName) {
		logger=LogManager.getLogger(ClassName);
		BasicConfigurator.configure();
		PropertyConfigurator.configure("Configuration\\log4j2.properties");
		return logger;
	}
	
	public static void handleAlert(String perform) {
		Alert alert = driver.switchTo().alert();
	if(perform.equals("Cancel")) {
		driver.switchTo().alert().dismiss();			
	}
	else if(perform.equals("Accept")) {
		driver.switchTo().alert().accept();
	}
	else if(perform.equals("Get Text")) {
AlertText=	driver.switchTo().alert().getText();	
	
	}
	else if(perform.equals("Send Text")) {
		driver.switchTo().alert().sendKeys("Text");
	}

	
	}


}


