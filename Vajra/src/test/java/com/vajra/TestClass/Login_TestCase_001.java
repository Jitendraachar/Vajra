package com.vajra.TestClass;

import java.sql.Driver;

import org.testng.annotations.Test;

import com.vajra.pageobjects.LoginPageObject;
import com.vajra.TestClass.*;

public class Login_TestCase_001 extends BaseClasss{
	
	@Test
	public void salesLogin() {
		LoginPageObject lpo= new LoginPageObject();
		driver.get(URL);
		lpo.EnterUserID();
		lpo.EnterUserPass();
		lpo.ClickOnLoginButton();
		
	}

}
