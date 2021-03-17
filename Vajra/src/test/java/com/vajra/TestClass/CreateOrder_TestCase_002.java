package com.vajra.TestClass;

import org.testng.annotations.Test;
import com.vajra.TestClass.*;
import com.vajra.pageobjects.CreateOrderPageObject;
public class CreateOrder_TestCase_002 extends BaseClasss{

	@Test(priority = 1)
	public void SearchCustomer() {
		Login_TestCase_001 tc= new Login_TestCase_001();
		tc.Login_TestCase_SE();
		CreateOrderPageObject cop= new CreateOrderPageObject(driver);
		cop.ClickOnHomeCreateDocument();
		cop.ClickOnSearchCustomer();
		cop.EnterCustomerID(OrderCustomerID);
		cop.ClickOnSearchButton();
		cop.SearchCustomerNameDisplay();
	}
	@Test(priority = 2)
	public void OrderHeaderPage() {
		CreateOrderPageObject cop= new CreateOrderPageObject(driver);
		cop.ActionButton();
		cop.CreateOrder();
		cop.VerifyOrderHeaderPage();
		cop.selectOccasion();
		cop.SelectOccasionDate();
		cop.EnterOccasionRemarks();
		cop.ClickOnNextButton();
		cop.VerifyOrderItemPage();

	}
}

