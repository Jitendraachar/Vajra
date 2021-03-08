package com.vajra.TestClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.vajra.utilities.*;

import com.vajra.utilities.Readconfig;

public class BaseClasss {
	//to read the config file using java
	public String evn=Readconfig.envirnoment();
	//to call different testing environment
	String URL;
	//set driver
	public static WebDriver driver;
	

	@BeforeClass
	public void setup(String br)
	{
		if(br.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", Readconfig.readChrompath());
		}
		else if(br.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", Readconfig.readFirefoxpath());
		}
	
		
	}
	public void envirnoment()
	{
		if(evn.equals("EXT"))
		{
			URL="http://192.168.1.10:2013/Sales";
		}
		else if(evn.equals("UAT"))
		{
			URL="http://192.168.1.10:2014/Sales";
		}
		else if(evn.equals("Cloud"))
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
