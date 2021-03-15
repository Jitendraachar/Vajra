package com.vajra.TestClass;


import org.testng.annotations.Test;

import com.vajra.pageobjects.LoginPageObject;

import junit.framework.Assert;

public class Login_TestCase_001 extends BaseClasss {

	@Test(priority = 0)
	public void Login_TestCase_SE() {
		//initiate the driver
		LoginPageObject lpo= new LoginPageObject(driver);

		driver.get(SalesURL);

		lpo.EnterUserID(SEID);
		lpo.EnterUserPass(SEpass);
		lpo.ClickOnLoginButton();
		Assert.assertEquals(driver.getTitle(), SalesTittle);
	}
	
	@Test(priority = 1)
	public void Login_TestCase_OrderSection() {
		//initiate the driver
		LoginPageObject lpo= new LoginPageObject(driver);
		driver.get(SalesURL);

		lpo.EnterUserID(OrderSectionID);
		lpo.EnterUserPass(OrderSectionPass);
		lpo.ClickOnLoginButton();
		Assert.assertEquals(driver.getTitle(), SalesTittle);
	}
	
	@Test(priority = 2)
	public void Login_TestCase_Cashier() {
		//initiate the driver
		LoginPageObject lpo= new LoginPageObject(driver);

		driver.get(SalesURL);

		lpo.EnterUserID(CashierID);
		lpo.EnterUserPass(CashierPass);
		lpo.ClickOnLoginButton();
		Assert.assertEquals(driver.getTitle(), SalesTittle);
	}
	
	@Test (priority = 3)
	public void Login_TestCase_StoreHead() {
		//initiate the driver
		LoginPageObject lpo= new LoginPageObject(driver);

		driver.get(SalesURL);

		lpo.EnterUserID(StoreHeadID);
		lpo.EnterUserPass(StoreHeadPass);
		lpo.ClickOnLoginButton();
		Assert.assertEquals(driver.getTitle(), SalesTittle);
	}
	
	@Test(priority = 4)
	public void Login_TestCase_OE() {
		//initiate the driver
		LoginPageObject lpo= new LoginPageObject(driver);
		driver.get(OEURL);
		lpo.EnterUserID(OEID);
		lpo.EnterUserPass(OEPass);
		lpo.ClickOnLoginButton();
		Assert.assertEquals(driver.getTitle(), SalesTittle);
	}
}

