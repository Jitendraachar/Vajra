package com.vajra.TestClass;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.vajra.pageobjects.AddCustomerSales;
import com.vajra.pageobjects.CreateOrderPageObject;

public class TC_CreateCustomer_003 extends BaseClasss {
	@Test(priority = 1)
	public void navigateToCustomerPage() {
		//TC_AllLogin_001 tc= new TC_AllLogin_001();
		//tc.Login_TestCase_SE();
		CreateOrderPageObject cop= new CreateOrderPageObject(driver);
		cop.ClickOnHomeCreateDocument();
		cop.ClickOnSearchCustomer();
	}
	@Test(priority = 2)
	public void EnterCustomerDetails() {
		AddCustomerSales acs= new AddCustomerSales(driver);
		acs.ClickOnCreateCustomerButton();
		acs.SelectCustomerTitle();
		acs.EnterCustomerFirstName();
		acs.EnterCustomerLastName();
		acs.SelectCustomerGender();
		acs.EnterCustomerAddressOne();
		acs.EnterCustomerAddressTwo();
		acs.EnterCustomerAddressThree();
		acs.EnterCustomerPANNumber();
		acs.EnterCustomerMobileNumberOne();
		acs.EnterCustomerMobileNumberTwo();
		acs.EnterCustomerLandLineHomeNumber();
		acs.EnterCustomerCustomerLandLineOffice();
		acs.SelectCustomerCountry();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		acs.SelectCustomerState();
		acs.SelectCustomerCity();
		acs.EnterCustomerEmailID();
		acs.EnterCustomerPINCode();
		acs.EnterCustomerGSTNumber();
		acs.EnterCustomerAdharCardNumber();
		acs.ClickOnAddCustomerButton();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		acs.VerifyCreatedCustomer();
	}
}
