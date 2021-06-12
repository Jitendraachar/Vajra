package com.vajra.TestClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vajra.pageobjects.LooseStoneStock;

public class TC_Loose_Stone_Stock_Report extends BaseClasss{
	TC_AllLogin_001 login= new TC_AllLogin_001();
	
@Test(dataProvider = "SELogin",priority = 0)
public void login(String UserName, String pass, String Exc, String LoginType){
	//Calling SE login from All Login Test Case
	 getLogger("TC_Loose_Stone_Stock_Report");
	
	login.Login_TestCase_SE(UserName, pass, Exc, LoginType);

}
@Test(priority = 1)
public void getAvailableDiamondData() throws InterruptedException {
	LooseStoneStock Stk= new LooseStoneStock(driver);
	logger.info("Login into Sales portal as SE");
	Stk.clickOnReportDropDown();
	logger.info("Clicked On Report Menu");
	Stk.clickOnStockSubMenu();
	logger.info("Clicked on Stock Sub Menu");
	Stk.clickOnLosseStoneStockSubMenu();
	logger.info("Clicked On Loose Stone Stock Sub Menu");
	Stk.selectStatusDropDown();
	logger.info("Status Drop Down has been selected as Available");
	Stk.storeOrDCDropDown("Store");
	logger.info("Store Or DC Drop Down has been selected as Store");
	Stk.storeOrDCNameButton();
	logger.info("Store or DC Name has been Selected");
	Stk.getloginZoneName();
	logger.info("Login Zone ID from UI is: "+Stk.loginZoneNamefromUI);
}

@DataProvider(name = "SELogin")
public String[][] GetSEData() throws IOException, InterruptedException {
	//Loading all data from excel 
	return login.getdata();
}

}
