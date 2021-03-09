package com.vajra.TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.vajra.utilities.*;

import com.vajra.utilities.Readconfig;

public class BaseClasss {
	//to read the config file using java
	Readconfig readconfig=new Readconfig();
	public String chrome=readconfig.readChrompath();
	public String firefoxpath=readconfig.readFirefoxpath();
	public String envi=readconfig.envirnoment();
	
	//set driver
	public static WebDriver driver;
	
	//to call different testing environment
	public static String URL;


	@Parameters("browser")
	

	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.readChrompath());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		}
		else if(br.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.readFirefoxpath());
		}
	
		
	}
	public void envirnoment()
	{
		if(envi.equals("EXT"))
		{
			URL="http://192.168.1.10:2013/Sales";
		}
		else if(envi.equals("UAT"))
		{
			URL="http://192.168.1.10:2014/Sales";
		}
		else if(envi.equals("Cloud"))
		{
			URL="http://103.1.114.170:2008/Sales";
		}
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
}
