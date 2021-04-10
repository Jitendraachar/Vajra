package com.vajra.TestClass;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.CreateCustomerOrderNoStoneAccessory;
import com.vajra.pageobjects.CustomerSearch;
import com.vajra.pageobjects.LoginPageObject;

import junit.framework.Assert;
import com.vajra.utilities.*;
public class TC_AllLogin_001 extends BaseClasss {


	@Test(dataProvider = "LoginUserIDs")
	public void Login_TestCase_SE(String username, String Passowrd,String Exc, String LoginType) { //initiate the driver
		if(LoginType.equals("SE")) {
			driver.get(SalesURL);
			LoginPageObject LPO=new LoginPageObject(driver);
			LPO.EnterUserID(username);
			LPO.EnterUserPass(Passowrd);
			LPO.ClickOnLoginButton();
			Assert.assertEquals(driver.getTitle(), SalesTittle);
		}
	}
	//@Test (dataProvider = "LoginUserIDs")
	public void Login_TestCase_Cashier(String username, String Passowrd,String Exc, String LoginType) { 
		if(LoginType.equals("Cashier")) {
			driver.get(SalesURL);
			LoginPageObject lpo= new LoginPageObject(driver);  
			lpo.EnterUserID(username);
			lpo.EnterUserPass(Passowrd);
			lpo.ClickOnLoginButton(); 
			Assert.assertEquals(driver.getTitle(),SalesTittle);
		}

	}

	//@Test(dataProvider = "LoginUserIDs") 
	public void Login_TestCase_StoreHead(String username, String Passowrd,String Exc, String LoginType) { //initiate the driver
		if(LoginType.equals("Store Head")) {
			driver.get(SalesURL);
			LoginPageObject lpo= new LoginPageObject(driver);
			lpo.EnterUserID(username);
			lpo.EnterUserPass(Passowrd);
			lpo.ClickOnLoginButton();
			Assert.assertEquals(driver.getTitle(), SalesTittle);
		}
	}

	@DataProvider(name="LoginUserIDs")
	public String[][] getdata() throws IOException, InterruptedException{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\vajra\\TestData\\Usernameandpassword.xlsx";
		//XLUtilities xlutil= new XLUtilities(path);

		int totalrows=XLUtilities.getRowCount(path,"Sale Login");
		int totalcols=XLUtilities.getCellCount(path, "Sale Login", 1);

		String logindata[][]= new String[totalrows][totalcols];

		for(int i=1;i<=totalrows;i++)
		{
			for (int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]=XLUtilities.getCellData(path,"Sale Login", i, j);			
			}
		}
		return 	logindata;
	}

}

