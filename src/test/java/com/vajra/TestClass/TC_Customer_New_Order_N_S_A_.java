package com.vajra.TestClass;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.CreateCustomerOrderNoStoneAccessory;
import com.vajra.pageobjects.CustomerSearch;
import com.vajra.pageobjects.LoginPageObject;
import com.vajra.utilities.XLUtilities;

import junit.framework.Assert;

public class TC_Customer_New_Order_N_S_A_ extends BaseClasss{
	TC_AllLogin_001 Login=new TC_AllLogin_001();
	//Login 
	@Test(priority = 0,dataProvider = "LoginUserId")
	public void loginSales(String username, String Passowrd,String Exc, String LoginType)throws IOException,InterruptedException {
		
		Login.Login_TestCase_SE(username, Passowrd, Exc, LoginType );
	}
		@Test(priority = 1)
		public void OrderHeader() throws InterruptedException {
			CustomerSearch CS=new CustomerSearch(driver);
			CreateCustomerOrderNoStoneAccessory  CCNSA=new CreateCustomerOrderNoStoneAccessory(driver);
				
		CS.Home_Create_Document();
		CS.Search_Customer();
		Thread.sleep(1000);
		CS.Search();
		Thread.sleep(1000);
		CCNSA.Actions();
		Thread.sleep(1000);
		CCNSA.Actionelement("  Create Order");
		Thread.sleep(1000);
		CCNSA.Occasion("Self");
		CCNSA.occasionDate();
		CCNSA.occasionRemarks("Jitu Automation");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		CCNSA.clickOnNextButton();
		Thread.sleep(3000);
	}
	@DataProvider(name = "LoginUserId")
	public String[][] getLoginData() throws IOException, InterruptedException{
		
		return Login.getdata();
		
	}
}