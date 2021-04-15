package com.vajra.TestClass;
import java.io.IOException;

import org.apache.logging.log4j.core.Logger;
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
		getLogger("TC_RaiseSalesBill_FGStock_001");
		login.Login_TestCase_SE(UserName, Pass, Exp, LoginType);		
	}
	@Test(priority = 1)
	public void GetFGStockDetails() throws InterruptedException {
		getLogger("TC_RaiseSalesBill_FGStock_001");
		logger.info("Akash");

		
		
		logger.info("Sales SE login Successfully and GetFGStockDetails test Case is starting");

		FGStock fgs= new FGStock(driver);
		logger.info("Object Created for FGStock PageObject Classes");
		fgs.ClickOnReportDropdown();
		logger.info("clicked on Report Menu Drop-Down");
		fgs.ClickOnStockDropDown();
		logger.info("clicked on Stock Sub-Menu Drop-Down");
		fgs.ClickOnFGStockSubMenu();
		logger.info("clicked on FG Stock Sub-Menu Drop-Down");
		fgs.SelectStatusDropdown("Available");
		logger.info("Search filter Status DropDown is Selected as FG Stock");
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
