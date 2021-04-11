package com.vajra.TestClass;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.CreateSaleBill;
import com.vajra.pageobjects.FGStock;
public class TC_RaiseSalesBill_FGStock_001 extends BaseClasss{
	TC_AllLogin_001 login=new TC_AllLogin_001();

	@Test(dataProvider = "SELogin",priority = 0)
	public void SELogin(String UserName, String Pass, String Exp, String LoginType) {
		login.Login_TestCase_SE(UserName, Pass, Exp, LoginType);		
	}
	@Test(priority = 1)
	public void GetFGStockDetails() throws InterruptedException {
		FGStock fgs= new FGStock(driver);
		fgs.ClickOnReportDropdown();
		fgs.ClickOnStockDropDown();
		fgs.ClickOnFGStockSubMenu();
		fgs.SelectStatusDropdown("Available");
		fgs.SelectStoreOrDCDropDown("Store");
		waitForElementNotClickable(fgs.SelectStoreNameAsTSMadision);
		fgs.SelectStoreOrDCNameDropDown("TS Madision");
		fgs.ClickOnZoneDropDown();
		//	waitForElementNotVisible(fgs.AllZoneName);
		fgs.getLoginZoneName();
		waitForElementNotClickable(fgs.SelectStoreNameAsTSMadision);
		fgs.SelectZoneDropDown(fgs.ZoneName);
		fgs.SelectSegment("Gold");
		fgs.ClickOnSearchButton();
		fgs.getFgStockNo();
		RaiseSaleBill();
	}

	@DataProvider(name="SELogin")
	public String[][] GetSEData() throws IOException, InterruptedException {
		return login.getdata();
	}
	public void RaiseSaleBill() {
		CreateSaleBill csb=new CreateSaleBill(driver);
		csb.ClickOnFunctionDropDown();
		csb.ClickOnBillSubMenu();
		csb.ClickOnSaleBillSubMenu();
		
		
	}
}