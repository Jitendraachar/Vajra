package com.vajra.TestClass;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.CreateSaleBill;
import com.vajra.pageobjects.FGStock;
import com.vajra.TestClass.TC_FG_Stock_Report_001;
public class TC_RaiseSalesBill_FGStock_001 extends BaseClasss{
	TC_AllLogin_001 login=new TC_AllLogin_001();
	TC_FG_Stock_Report_001 GetFGStockReport= new TC_FG_Stock_Report_001();
	String FGStockNumber;
	String FGStockWeight;
	//private static final Logger logger = (Logger) LogManager.getLogger(TC_RaiseSalesBill_FGStock_001.class);
	//TC_FG_Stock_Report_001 FGDetail=new TC_FG_Stock_Report_001();
	@Test(dataProvider = "SELogin",priority = 0)
	public void SELogin(String UserName, String Pass, String Exp, String LoginType) {
		getLogger("TC_RaiseSalesBill_FGStock_001");
		login.Login_TestCase_SE(UserName, Pass, Exp, LoginType);		
		logger.info("Sales SE login Successfully and GetFGStockDetails test Case is starting");		
	}
	//@Test(priority = 1)
	public void RaiseSaleBillFGStockGold() throws InterruptedException {
		GetFGStockReport.FGStockAvailabeGoldDetail();
		FGStockNumber	=GetFGStockReport.StockNo;
		FGStockWeight=GetFGStockReport.StockWt;
		
		RaiseSaleBillFGStock();
	}
	//@Test(priority = 2)
	public void RaiseSaleBillFGStockSilver() throws InterruptedException {
		GetFGStockReport.FGStockAvailabeSilverDetail();
		FGStockNumber	=GetFGStockReport.StockNo;
		FGStockWeight=GetFGStockReport.StockWt;
		logger.info("Sales SE login Successfully and GetFGStockDetails test Case is starting");
		RaiseSaleBillFGStock();
	}
	@Test(priority = 3)
	public void RaiseSaleBillFGStockPlatinum() throws InterruptedException {
		GetFGStockReport.FGStockAvailabePlatinumDetail();
		FGStockNumber	=GetFGStockReport.StockNo;
		FGStockWeight=GetFGStockReport.StockWt;
		logger.info("Sales SE login Successfully and GetFGStockDetails test Case is starting");
		RaiseSaleBillFGStock();
	}
	public void RaiseSaleBillFGStock() throws InterruptedException {
		logger.info("Raise Sale Bill Method has been Started");
		CreateSaleBill csb=new CreateSaleBill(driver);
		logger.info("Object has been created for CreateSaleBill page Object");
		csb.ClickOnFunctionDropDown();
		logger.info("Clicked On Function menu");
		csb.ClickOnBillSubMenu();
		logger.info("Clicked On Bill Sub Menu");
		csb.ClickOnSaleBillSubMenu();
		logger.info("Clicked On Sale Bill Sub Menu");
		csb.SelectCreatOrSearchSaleBillDropDown();
		logger.info("Sale Create or Search DropDown has been Selected");
		csb.SelectCreateSaleBill();
		logger.info("Under Dropdown, Create Sale Bill Has been Selected");
		csb.selectDocType();
		logger.info("Showing selectDocType Dropdown");
		csb.selectFgStockUnderDocTypeDropDown();
		logger.info("Doc Type DropDown has been Selected as FG Stock");
		csb.SearchCustomerBox();
		logger.info("Sending Customer ID to Search Customer Box");
		csb.ClicksearchCustomerButton();
		logger.info("Clicked on Search Customer");
		csb.SelectCustomerFromPopUp();
		logger.info("Selected Customer from Search page of Customer");
		csb.OkButtonForCustomerSearch();
		logger.info("Clicked on Ok button from popup");
        Thread.sleep(500);
		csb.SaleBillCreatePageCustomerName();
		csb.enterStockNumber(FGStockNumber);
		logger.info("Entering FG Stock Number: "+FGStockNumber);
		csb.EnterStockWt(FGStockWeight);
		logger.info("Entering FG Stock Weight :"+FGStockWeight);
		csb.ClickOnGetSaleBillGrid();
		logger.info("Clicked on geting data arrow Button");
		Thread.sleep(2000);
csb.AnyExceptionAfterGettingData();
logger.info("Checked for any exception");
	}
	@DataProvider(name="SELogin")
	public String[][] GetSEData() throws IOException, InterruptedException {
		return login.getdata();
	}

}
