package com.vajra.TestClass;
import java.io.IOException;

import org.testng.annotations.*;

import com.vajra.pageobjects.LoginPageObject;
import com.vajra.utilities.XLUtilities;

import junit.framework.Assert;

public class LoginusingExcelsheet extends BaseClasss{

	@Test(dataProvider="LoginUserIDs")
	public void loginSales(String username, String Passowrd,String exp)throws IOException,InterruptedException {
		driver.get(SalesURL);
		LoginPageObject LPO=new LoginPageObject(driver);
		
		LPO.EnterUserID(username);
		LPO.EnterUserPass(Passowrd);
		LPO.ClickOnLoginButton();
		String exp_title="Sales - Dashboard - Sales";
		String Actual_title=driver.getTitle();
		
		if(exp.equals("Valid"))
		{
			if(exp_title.equals(Actual_title))
			{
				LPO.logoutlink();
				Assert.assertTrue(true);
			}
		else
		{
			Assert.assertTrue(false);
			
		}
	}
		else if(exp.equals("Invalid"))
		{
			if(exp_title.equals(Actual_title))
			{
				LPO.logoutlink();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}
	@DataProvider(name="LoginUserIDs")
	public String[][] getdata(){
		String logindata[][]= {
				{"19","gouri@28","Valid"},
				{"0","pass123","Invalid"},
				{"15","pass123","Valid"}
		};
		
		
			return 	logindata;
		}
	
	
}
