package com.vajra.TestClass;

import java.sql.Driver;

import org.testng.annotations.Test;

import com.vajra.pageobjects.LoginPageObject;
import com.vajra.TestClass.*;

public class Login_TestCase_001 extends BaseClasss {
	
	@Test
	public void Login_TestCase_001() {
		LoginPageObject lpo= new LoginPageObject(driver);
		driver.get("URL");
		lpo.EnterUserID();
		lpo.EnterUserPass();
		lpo.ClickOnLoginButton();
		
	}

}
