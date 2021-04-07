package com.vajra.TestClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.CreateCustomerOrderNoStoneAccessory;
import com.vajra.pageobjects.CustomerSearch;
import com.vajra.pageobjects.LoginPageObject;
import com.vajra.utilities.XLUtilities;

import junit.framework.Assert;

public class TC_Customer_New_Order_N_S_A_ extends BaseClasss{
	
	//Login 
		@Test(dataProvider="LoginUserIDs",priority=1)
		public void loginSales(String username, String Passowrd,String Exc)throws IOException,InterruptedException {
			driver.get(SalesURL);
			LoginPageObject LPO=new LoginPageObject(driver);
			CustomerSearch CS=new CustomerSearch(driver);
			CreateCustomerOrderNoStoneAccessory  CCNSA=new CreateCustomerOrderNoStoneAccessory(driver);
			LPO.EnterUserID(username);
			LPO.EnterUserPass(Passowrd);
			LPO.ClickOnLoginButton();
			String Actual_title=driver.getTitle();
			String exp_title="Sales - Dashboard - Sales";
			captureScreenShot(driver, "Login Page");
			
			if(Exc.equals("Valid"))
			{
				if(exp_title.equals(Actual_title))
				{
					LPO.logoutlink();
					Assert.assertTrue(true);
					CS.Home_Create_Document();
					CS.Search_Customer();
					Thread.sleep(1000);
					CS.Search();
					Thread.sleep(1000);
					CCNSA.Actions();
					Thread.sleep(1000);
					CCNSA.Actionelement("  Create Order");
					Thread.sleep(1000);
					LPO.logoutbutton();
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			else if(Exc.equals("Invalid"))
			{
				if(exp_title.equals(Actual_title))
				{
					LPO.logoutlink();
					LPO.logoutbutton();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}

		}
		@DataProvider(name="LoginUserIDs")
		public String[][] getdata() throws IOException, InterruptedException{
			String path="C:\\Users\\jitendra.y\\git\\Vajra\\Vajra\\src\\test\\java\\com\\vajra\\TestData\\Usernameandpassword.xlsx";
			//XLUtilities xlutil= new XLUtilities(path);
			
			int totalrows=XLUtilities.getRowCount(path,"Customer search");
			int totalcols=XLUtilities.getCellCount(path, "Customer search", 1);
			
			String logindata[][]= new String[totalrows][totalcols];
			
			for(int i=1;i<=totalrows;i++)
			{
				for (int j=0;j<totalcols;j++)
				{
					logindata[i-1][j]=XLUtilities.getCellData(path,"Customer search", i, j);			
				}
			}
			return 	logindata;
		}
		
	}

