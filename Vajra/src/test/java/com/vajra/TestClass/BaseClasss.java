package com.vajra.TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.vajra.utilities.Readconfig;

public class BaseClasss {
	// set driver

	// to read the config file using java
	Readconfig readconfig = new Readconfig();
	public String chrome = readconfig.readChrompath();
	public String firefoxpath = readconfig.readFirefoxpath();
	public String envi = readconfig.envirnoment();
	public static WebDriver driver;

	// to call different testing environment
	public static String URL;

	@Parameters("browser")

	@BeforeClass

	
	  public void setup(String br) { 
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
	  System.setProperty("WebDriver.chrome.driver",readconfig.readChrompath());
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS); 
	  } 
		else if(br.equals("Firefox")) 
	  {
		  driver =new FirefoxDriver();
		  System.setProperty("webdriver.gecko.driver",readconfig.readFirefoxpath());
	  }
	}
	  
	 @Parameters("envi")
	public void envirnoment(String envi) {
		if (envi.equals("EXT")) {
			URL = "http://192.168.1.10:2013/Sales";
		} else if (envi.equals("UAT")) {
			URL = "http://192.168.1.10:2014/Sales";
		} else if (envi.equals("Cloud")) {
			URL = "http://103.1.114.170:2008/Sales";
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
