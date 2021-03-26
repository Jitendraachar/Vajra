package com.vajra.TestClass;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.LoginPageObject;

import junit.framework.Assert;
import com.vajra.utilities.*;
public class TC_AllLogin_001 extends BaseClasss {
	
	
	@Test(dataProvider="loginDetails")
	public void LoginSales(String User, String Password)throws InterruptedException,IOException
	{
		LoginPageObject lpo= new LoginPageObject(driver);
		driver.get("http://192.168.1.10:2013/Sales/");
		lpo.EnterUserID(User);
		lpo.EnterUserPass(Password);
		lpo.ClickOnLoginButton();
		Assert.assertEquals(driver.getTitle(), SalesTittle);
		captureScreenShot(driver, "loginsales");
	}
	@DataProvider(name ="loginDetails") 
	public static Object[][] login()throws IOException {
		String path=System.getProperty("C:\\Users\\jitendra.y\\git\\Vajra\\Vajra\\src\\test\\java\\com\\vajra\\TestData\\Usernameandpassword.xlsx");
		int rownum=XLUtilities.getRowCount(path, "Sale Login");
		int cocount=XLUtilities.getCellCount(path, "Sale Login", 1);
		String logindata[][]=new String [rownum][cocount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<=cocount;j++)
			{
				logindata[i-1][j]=XLUtilities.getCellData( path,"Sale Login", i, j);
			}
		}
		return logindata;
		
	}
	
	/*
	 * @Test(priority = 0) public void Login_TestCase_SE() { //initiate the driver
	 * LoginPageObject lpo= new LoginPageObject(driver);
	 * 
	 * driver.get(SalesURL);
	 * 
	 * lpo.EnterUserID(SEID); lpo.EnterUserPass(SEpass); lpo.ClickOnLoginButton();
	 * Assert.assertEquals(driver.getTitle(), SalesTittle); }
	 * 
	 * @Test(priority = 1) public void Login_TestCase_OrderSection() { //initiate
	 * the driver LoginPageObject lpo= new LoginPageObject(driver);
	 * driver.get(SalesURL);
	 * 
	 * lpo.EnterUserID(OrderSectionID); lpo.EnterUserPass(OrderSectionPass);
	 * lpo.ClickOnLoginButton(); Assert.assertEquals(driver.getTitle(),
	 * SalesTittle); }
	 * 
	 * @Test(priority = 2) public void Login_TestCase_Cashier() { //initiate the
	 * driver LoginPageObject lpo= new LoginPageObject(driver);
	 * 
	 * driver.get(SalesURL);
	 * 
	 * lpo.EnterUserID(CashierID); lpo.EnterUserPass(CashierPass);
	 * lpo.ClickOnLoginButton(); Assert.assertEquals(driver.getTitle(),
	 * SalesTittle); }
	 * 
	 * @Test (priority = 3) public void Login_TestCase_StoreHead() { //initiate the
	 * driver LoginPageObject lpo= new LoginPageObject(driver);
	 * 
	 * driver.get(SalesURL);
	 * 
	 * lpo.EnterUserID(StoreHeadID); lpo.EnterUserPass(StoreHeadPass);
	 * lpo.ClickOnLoginButton(); Assert.assertEquals(driver.getTitle(),
	 * SalesTittle); }
	 * 
	 * @Test(priority = 4) public void Login_TestCase_OE() { //initiate the driver
	 * LoginPageObject lpo= new LoginPageObject(driver); driver.get(OEURL);
	 * lpo.EnterUserID(OEID); lpo.EnterUserPass(OEPass); lpo.ClickOnLoginButton();
	 * Assert.assertEquals(driver.getTitle(), OETittle); }
	 */
}

