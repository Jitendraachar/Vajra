package com.vajra.TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.FGStock;

public class TC_FG_Stock_Report_001 extends BaseClasss{
	TC_AllLogin_001 login=new TC_AllLogin_001();
	public static String StockWt;
	public static String StockNo;
	@Test(dataProvider = "SELogin",priority = 0)
	public void SELogin(String UserName, String Pass, String Exp, String LoginType) {
		getLogger("TC_FG_Stock_Report_001");
		login.Login_TestCase_SE(UserName, Pass, Exp, LoginType);		
	}

	@DataProvider(name="SELogin")
	public String[][] GetSEData() throws IOException, InterruptedException {
		return login.getdata();
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
		StockNo=FGStock.FGStockNo;
		StockWt=FGStock.FgStockWt;

		logger.info("FG Stock number of "+StockNo+" Weight is "+StockWt);

	}

}
