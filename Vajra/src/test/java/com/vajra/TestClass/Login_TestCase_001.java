package com.vajra.TestClass;

import java.sql.Driver;

import org.testng.annotations.Test;

import com.vajra.pageobjects.LoginPageObject;
import com.vajra.TestClass.*;

public class Login_TestCase_001 extends BaseClasss {
	
	@Test
	public void salesLogin() {
		LoginPageObject lpo= new LoginPageObject();
		driver.get("http://103.1.114.170:2008/Sales");
		lpo.EnterUserID();
		lpo.EnterUserPass();
		lpo.ClickOnLoginButton();
		
	}

}
