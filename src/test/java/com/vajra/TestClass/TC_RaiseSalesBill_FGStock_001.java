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
		logger.info("Search filter Status DropDown is Selected as Available");
		fgs.SelectStoreOrDCDropDown("Store");
		logger.info("Search filter Store/DC Type DropDown is Selected as Store");
		waitForElementNotClickable(fgs.SelectStoreNameAsTSMadision);
		logger.info("Waited for Store/DC Name Drop Down");

		fgs.SelectStoreOrDCNameDropDown("TS Madision");
		logger.info("Search filter Store/DC Name DropDown is Selected as Available");
		fgs.ClickOnZoneDropDown();
		logger.info("Clicked on Zone Dropdown");
		fgs.getLoginZoneName();
		logger.info("Getting SE login ID Zone and login Zone ID is "+fgs.ZoneName);
		waitForElementNotClickable(fgs.SelectStoreNameAsTSMadision);
		logger.info("Waiting for Store Name is Clickable");
		fgs.SelectZoneDropDown(fgs.ZoneName);
		logger.info("Zone Name DropDown has been Selected as "+fgs.ZoneName);
		fgs.SelectSegment("Gold");
		logger.info("Segment Drop-down has been Selected");
		fgs.ClickOnSearchButton();
		logger.info("Clicked on Search Button");
		fgs.getFgStockNo();
		logger.info("FG Stock Weight of "+fgs.FGStockNo+" is "+fgs.FgStockWt);
		RaiseSaleBill();
	
	}

	@DataProvider(name="SELogin")
	public String[][] GetSEData() throws IOException, InterruptedException {
		return login.getdata();
	}
	public void RaiseSaleBill() {
		logger.info("Raise Sale Bill Method has been Started");
		CreateSaleBill csb=new CreateSaleBill(driver);
		logger.info("Object has been created for CreateSaleBill page Object");
		csb.ClickOnFunctionDropDown();
		logger.info("Clicked On Function menu");
		csb.ClickOnBillSubMenu();
		logger.info("Clicked On Bill Sub Menu");
		csb.ClickOnSaleBillSubMenu();
		logger.info("Clicked On Sale Bill Sub Menu");		
		
	}
}
