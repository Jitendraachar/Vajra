package com.vajra.TestClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vajra.utilities.Readconfig;

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
	/*
	 * public static String SEID="63"; public static String SEpass="pass123";
	 * 
	 * public static String OrderSectionID="17"; public static String
	 * OrderSectionPass="pass123";
	 * 
	 * public static String CashierID="15"; public static String
	 * CashierPass="pass123";
	 * 
	 * public static String StoreHeadID="11"; public static String
	 * StoreHeadPass="pass123";
	 * 
	 * public static String OEID="110"; public static String OEPass="pass123";
	 */	public static String SalesTittle="Sales - Dashboard - Sales";
	public static String OETittle="";
	// to call different testing environment
	public static String SalesURL;
	public static String OEURL;
	
public static String OrderCustomerID="8";
	//public static String br;


	@BeforeClass


	public void setup() { 
		driverSetUp();
		envSetUp();
	}

	public void driverSetUp() {	
		//br="chrome";
		if(Browser.equals("Chrome")) {
			//	Actions	action = new Actions(driver);
			//	System.setProperty("webdriver.chrome.driver","C:\\Users\\shubh\\git\\Vajra\\Vajra\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");

			//		System.setProperty("webdriver.chrome.driver",readconfig.readChrompath());
			driver = new ChromeDriver();

			driver.manage().window().maximize();
		}


		// driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); } else
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
		File Trgt=new File("C:\\Users\\jitendra.y\\workspace\\VajraV1\\ScreenShots"+tname+".png");
		FileUtils.copyFile(Src, Trgt);
	}
	
}
	
