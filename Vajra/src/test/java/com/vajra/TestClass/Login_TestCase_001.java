package com.vajra.TestClass;


import org.testng.annotations.Test;

import com.vajra.pageobjects.LoginPageObject;

import junit.framework.Assert;

import com.vajra.TestClass.*;

public class Login_TestCase_001 extends BaseClasss {

	@Test
	public void Login_TestCase() {
		//initiate the driver
		LoginPageObject lpo= new LoginPageObject(driver);

		driver.get(URL);

		lpo.EnterUserID(SEID);
		lpo.EnterUserPass(SEpass);
		lpo.ClickOnLoginButton();
	//	String ExpectedPageTitle="Sales - Dashboard - Sales";
		//String ActualPageTitle=		driver.getTitle();

		if(driver.getTitle().equals("Sales - Dashboard - Sales")) {
			Assert.assertTrue(true);		
		
		}
		else Assert.assertTrue(false);
	
	}
}

