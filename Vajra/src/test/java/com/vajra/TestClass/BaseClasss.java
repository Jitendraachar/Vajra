package com.vajra.TestClass;

import java.util.concurrent.TimeUnit;

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
//	public String envirnoment = readconfig.envirnoment();
	public String Browser=readconfig.readBrowser();
	public static WebDriver driver;
public static String SEID="13";

public static String SEpass="pass123";

	// to call different testing environment
	public static String URL;
	//public static String br;


	@BeforeClass


	public void setup() { 
		driverSetUp();
		envSetUp();
	}
	@AfterClass
	public void teardown() {
		driver.quit();
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
	String	envirnoment="Cloud";
		if (envirnoment.equals("EXT")) {
			URL = "https://www.google.com/";
		} else if (envirnoment.equals("UAT")) {
			URL = "https://www.google.com/";
		} else if (envirnoment.equals("Cloud")) {
			URL = "http://103.1.114.170:2008/Sales/";
		}


	}
}